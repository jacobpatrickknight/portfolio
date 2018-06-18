/*
 * Jacob Knight
 * CMPE 320
 * Allows use of terminal commands through a program
 */ 

#include <unistd.h> 
#include <stdio.h> 
#include <sys/wait.h> 
#include <stdlib.h>
#include <string.h>

/*
 * execute - execute the given command with the given arguments, and the given environment
 * const char *binary - the name of the binary file to load (e.g. /bin/ls)
 * char *const arguments[] - the argv array - remember, argv[0] must be the commnad name
 * char *const envp[] - the array of environment variables for this session
 *
 * note:
 * const char *variable - a string whose contents won't be changed
 * char *const variable[] - an array of pointers (strings) whose content's won't be changed
 *        - but the things the pointers point at may be changed
 */

void execute (const char *binary, char *const arguments[], char *const envp[])
{
	if (execve(binary, arguments, envp) < 0)
	{
		perror("Could not execute command.");
	}
}

int main (int argc, char ** argv, char **envp)
{	
	// pid returns -1, 0, or a positive integer 
	pid_t pid = fork( ); 

	// pid is negative? indicates an error
	if (pid < 0)
	{
		perror("Error: forked failed.");
		exit(-1);
	}

	// pid is 0? a new process was created, and this copy is it
	if (pid == 0)
	{		
		char input[20];
		while (1)
		{
			printf("\nEnter a command with arguments: ");
			fgets(input, 20, stdin);
			if (strcmp(input, "exit\n") == 0)
				return 0;
		
			system(input);
		}
	}
	// pid is not 0? then it is the pid of the child
	else
	{
		int status;

		printf("This is the parent pid, its child is %d\n", pid);
		waitpid(pid, &status, 0);
		printf("This is still the parent: child exited with status %x\n", status);
	}

	return 0;
}