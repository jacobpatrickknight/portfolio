/**
 * Jacob Knight
 * CMPE 320
 * Prints all the command line arguments and environment variables of the program
 */ 

#include <stdio.h> 
#include <stdlib.h>

int main (int c, char **argv, char ** envp)
{	
	printf("\nCommand Line Arguments:\n");	
	for (int i = 0; argv[i] != '\0'; i++)
		printf("%s\n", argv[i]);

	printf("\nEnvironment Variables:\n");	
	for (int i = 0; envp[i] != '\0'; i++)
		printf("%s\n", envp[i]);

	return 0;
}