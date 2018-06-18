/* Lab 5: VM
*  Programmer: Jacob Knight
*  Course: CMPE 320
*  Section: 1 (9-10:50am)
*  Instructor: S.Lee
*/

#include <stdio.h>

#define PAGE_BITS 8
#define OFFSET_BITS 8 
#define BUFFER_SIZE 10
#define SIZE 7

int getPageNumber(int address);
int getOffset(int address);

/*
 * Tests that getPageNumber and getOffset work properly.
 */
int main (int argc, char** argv)
{
	int testNumbers[SIZE] = {1, 256, 32768, 32769, 128, 65534, 33153};
	int pageNumbers[SIZE];
	int offsets[SIZE];
	
	for (int i = 0; i < SIZE; i++)
	{
		pageNumbers[i] = getPageNumber(testNumbers[i]);
		offsets[i] = getOffset(testNumbers[i]);
		printf("Integer: %d\n", testNumbers[i]);
		printf("Page Number: %d\n", pageNumbers[i]);
		printf("Offset: %d\n\n", offsets[i]);
	}
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
	return address & ((1 << OFFSET_BITS) - 1);
}