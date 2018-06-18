/* Lab 5: VM
*  Programmer: Jacob Knight
*  Course: CMPE 320
*  Section: 1 (9-10:50am)
*  Instructor: S.Lee
*/

#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h> 
#include <string.h>

#define TLB_SIZE 16
#define PAGES 256
#define PAGE_SIZE 256
#define MEMORY_SIZE PAGES * PAGE_SIZE
#define PAGE_BITS 8
#define OFFSET_MASK 255
#define BUFFER_SIZE 10
#define ADDRESS_TOTAL 1000

// Method headers
void checkParameters(int argc, char **argv);
void openBinFile(char *fileName);
void getVirtualAddresses(char *fileName);
int getPhysicalAddress(int pageNumber, int offset);
int getValue(int address);
int checkTlb(int pageNumber);
int checkPageTable(int pageNumber);
void updateTLB(int pageNumber, int frameNumber);
void updatePageTable(int pageNumber, int frameNumber);
int getPageNumber(int address);
int getOffset(int address);
void outputResults(int i);
void outputStatistics();

// Variables for file names and the backing store map
char *binFileName;
char *addressFileName;
char *dataMap;

// Variables for memory, tlb, and page table
char physicalMemory[MEMORY_SIZE];
int tlb[TLB_SIZE][2];
int tlbCount = 0;
int pageTable[PAGES][2];
int pageTableCount = 0;
int memoryPosition;

// Variables for page numbers and offsets
int pageNumbers[ADDRESS_TOTAL];
int offsets[ADDRESS_TOTAL];

// Variables for output
int virtualAddresses[ADDRESS_TOTAL];
int physicalAddresses[ADDRESS_TOTAL];
int values[ADDRESS_TOTAL];
int addressesTranslated = 0;
int pageFaults = 0;
int tlbHits = 0;

/*
 * Retrieves the address data and starts the translation process.
 */
void main (int argc, char **argv)
{
	// Checks that the file arguments are valid
	checkParameters(argc, argv);
	
	// Opens the bin file and create the mapping
	openBinFile(binFileName);
	
	// retrieves the virtual addresses
	getVirtualAddresses(addressFileName);
	
	/*
	 * Finds the page numbers, offsets, physical addresses, and values
	 * for each virtual address and outputs the results.
	 */
	for (int i = 0; i < ADDRESS_TOTAL; i++)
	{	
		pageNumbers[i] = getPageNumber(virtualAddresses[i]);
		offsets[i] = getOffset(virtualAddresses[i]);
		physicalAddresses[i] = getPhysicalAddress(pageNumbers[i], offsets[i]);
		values[i] = getValue(physicalAddresses[i]);
		
		outputResults(i);
	}
	
	// Outputs the statistics for the address translation
	outputStatistics();
}

/*
 * Checks that the file names provided
 * in the arguments are valid.
 */
void checkParameters(int argc, char **argv)
{
	if (argc > 1)
	{
		if (argv[1] != NULL)
			binFileName = argv[1];
		else
			binFileName = "BACKING_STORE.bin";
		
		if (argv[2] != NULL)
			addressFileName = argv[2];
		else
			addressFileName = "addresses.txt";
	}
	else
	{
		binFileName = "BACKING_STORE.bin";
		addressFileName = "addresses.txt";
	}
}

/*
 * Opens the bin file if exists.
 */
void openBinFile(char *fileName)
{
	int binFile = open(binFileName, O_RDONLY);
	if (binFile < 0)
	{
		printf("Error :: Could not open %s\n", fileName);
		exit(0);
	}
	dataMap = mmap(0, MEMORY_SIZE, PROT_READ, MAP_SHARED, binFile, 0);
}

/*
 * Opens the address file if it exists
 * and stores the virtual addresses.
 */
void getVirtualAddresses(char *fileName)
{
	FILE *addressFile;
	addressFile = fopen(fileName, "r");
	unsigned char buffer[BUFFER_SIZE];
	
	if (addressFile == NULL)
	{
		printf("Error :: Could not open %s\n", fileName);
		exit(0);
	}
	
	int i = 0;
	while (fgets(buffer, BUFFER_SIZE, addressFile) != NULL)
	{
		virtualAddresses[i] = atoi(buffer);
		i++;
	}
	fclose(addressFile);
}

/*
 * Calculates the physical address.
 * First checks the tlb, then the page table for the frame number.
 * If neither hold the frame number, the address is extracted from the bin file.
 */
int getPhysicalAddress(int pageNumber, int offset)
{
	int pageAddress = pageNumber * PAGE_SIZE;
	int frameNumber;
	
	// Checks the tlb, increments value for tlb hits if successful
	frameNumber = checkTlb(pageNumber);
	if (frameNumber > -1)
		tlbHits++;
	else
	{
		// Checks the page table
		frameNumber = checkPageTable(pageNumber);
		
		// updates TLB if successful
		if (frameNumber > -1)
			updateTLB(pageNumber, frameNumber);
		/*
		 * Finds the frame number in the bin file
		 * if it isn't in the TLB or page table.
		 */
		else
		{
			frameNumber = memoryPosition;
			updateTLB(pageNumber, frameNumber);
			updatePageTable(pageNumber, frameNumber);
			memcpy(physicalMemory + memoryPosition, dataMap + pageAddress, PAGE_SIZE);
			memoryPosition += PAGE_SIZE;
		}
	}
	// Increments the number of addresses succesfully translated
	addressesTranslated++;
	return frameNumber + offset;
}

/*
 * Checks if the selected page number corresponds
 * to an entry in the TLB.
 */
int checkTlb(int pageNumber)
{
	int frameNumber = -1;
	for (int i = 0; i < TLB_SIZE; i++)
	{
		if (pageNumber == tlb[i][0])
			frameNumber = tlb[i][1];
	}
	return frameNumber;
}

/*
 * Checks if the selected page number corresponds
 * to an entry in the page table.
 */
int checkPageTable(int pageNumber)
{
	int frameNumber = -1;
	for (int i = 0; i < PAGES; i++)
	{
		if (pageNumber == pageTable[i][0])
			frameNumber = pageTable[i][1];
	}
	return frameNumber;
}

/*
 * Updates the TLB with the latest page number
 * and frame number translated.
 */
void updateTLB(int pageNumber, int frameNumber)
{
	if (tlbCount >= TLB_SIZE)
		tlbCount = 0;
	
	tlb[tlbCount][0] = pageNumber;
	tlb[tlbCount][1] = frameNumber;
	tlbCount++;
}

/*
 * Updates the page table with the latest page number
 * and frame number translated.
 */
void updatePageTable(int pageNumber, int frameNumber)
{
	if (pageTableCount >= PAGES)
		pageTableCount = 0;
		
	pageTable[pageTableCount][0] = pageNumber;
	pageTable[pageTableCount][1] = frameNumber;
	pageTableCount++;
	pageFaults++;
}

/*
 * Gets the value from the specified address
 * from the physical memory array.
 */
int getValue(int address)
{
	return physicalMemory[address];
}

/*
 * Finds the page number of the address
 * by extracting the first 8 bits.
 */
int getPageNumber(int address)
{
	return address >> PAGE_BITS;
}

/*
 * Finds the offset of the address
 * by extracting the last 8 bits.
 */
int getOffset(int address)
{
	return address & OFFSET_MASK;
}

/*
 * Outputs the results for virtual addresses, physical addresses, and values
 */
void outputResults(int i)
{
	printf("\nVirtual address: %d", virtualAddresses[i]);
	printf("\t\tPhysical address: %d", physicalAddresses[i]);
	printf("\t\tValue: %d", values[i]);
}

/*
 * Outputs the data for how well the translation performed
 */
void outputStatistics()
{
	printf("\nNumber of Translated Addresses = %d", addressesTranslated);
	printf("\nPage Faults = %d", pageFaults);
	printf("\nPage Fault Rate = %.3f", (double)pageFaults / ADDRESS_TOTAL);
	printf("\nTLB Hits = %d", tlbHits);
	printf("\nTLB Hit Rate = %.3f", (double)tlbHits / ADDRESS_TOTAL);
	printf("\n\n");
}