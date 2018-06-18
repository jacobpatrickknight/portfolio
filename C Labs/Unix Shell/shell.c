/*
* Project 1: UNIX Shell
* Programmer: Jacob Knight
* Course: CMPE 320
* Section: 1 (9:00 - 10:50am)
* Instructor: S. Lee
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

#define MAX_LINE 80 					// The maximum length command
#define MAX_HISTORY 10
#define DELIMITERS " \n\t\r\a&"

int line_size = MAX_LINE / 2 + 1;
char history[MAX_HISTORY][MAX_LINE];			// stores commands used
int command_count = 0;					// counts the number of commands in history
char *command_copy;					// Used for copying the command line

char *read_command_line (void);
char **create_arguments (char *command_line);
void execute (char **args, int background);
void show_history();
void update_history(char *command_line);

/**
 * @brief Creates a shell interface
 * @return 0 if successfully exited
 */
int main ()
{
	char *command_line; 				// command line input
	char **args;					// arguments separated
	int should_run = 1;				// flag to determine when to exit program
	int background = 0;
	
	printf("\n*** Unix Shell ***\n");
	while (should_run)
	{
		
		printf("shell> ");
		fflush(stdout);
		command_line = read_command_line();
		
		if (strstr(command_line, "&") != NULL)
			background = 1;
		// If "exit" is entered, the shell ends
		if (strcmp(command_line, "exit\n") == 0)
			should_run = 0;
		
		// If "history" is entered, the 10 most recent commands are displayed
		else if (strcmp(command_line, "history\n") == 0)
		{
			// if there are commands stored in history, they are shown
			if (command_count > 0)
			{
				show_history();
			}
			else
				printf("Error :: No commands in history");
			printf("\n");
		}
		
		// If "!!" is entered, the most recent command is executed
		else if (strcmp(command_line, "!!\n") == 0)
		{
			// if there are commands stored in history,
			// the most recent command is executed
			if (command_count > 0)
			{
				// creates and executes the command
				args = create_arguments(history[0]);
				execute(args, background);
				
				// updates the command history
				update_history(history[0]);
				free(args);
				free(command_copy);
			}
			else
				printf("Error :: No commands in history");
			printf("\n");
		}
		
		// If "!" followed by a number is entered,
		// the command associated with that number in history is executed
		else if (strstr(command_line, "!") != NULL)
		{
			// takes in the number inputted and converts it into a command number
			int number = atoi(++command_line);
			command_line--;
			int command = command_count - number;
			// if there are commands stored in history,
			// the command associated with the inputted number is executed
			if (command_count < 1)
				printf("Error :: No commands in history");
			else if (number > command_count)
				printf("Error :: Command doesn't exist");
			else if (command >= 0)
			{
				char tempcmd[line_size];
				strcpy(tempcmd, history[command]);
				// creates and executes the command
				args = create_arguments(history[command]);
				execute(args, background);
				
				// updates the command history
				update_history(tempcmd);
				free(args);
				free(command_copy);
			}
			else
				printf("Error :: Command doesn't exist");
			printf("\n");
		}
		
		// If the input isn't empty, a command is generated and executed
		else if (strcmp(command_line, "\n") != 0)
		{
			// creates and executes the command
			args = create_arguments(command_line);
			execute(args, background);
			// updates the command history
			update_history(command_line);
			free(args);
			free(command_copy);
			printf("\n");
		}
		free(command_line);
		background = 0;
	}
	return 0;
}

/**
 * @brief Reads input from the user and stores it into a char pointer
 * @return char* line - the line of input from the user
 */
char *read_command_line(void)
{
	char *line = malloc(sizeof(char) * line_size);
	fgets(line, line_size, stdin);
	return line;	
}

/**
 * @brief Creates a tokenized argument command
 * @param char *line
 * @return char **arguments
 */
char **create_arguments(char *command_line)
{
	int buffer = line_size;
	int pos = 0;
	char **arguments = malloc(buffer * sizeof(char*));
	char *token;
	
	// tokenizes the input and stores it into arguments
	command_copy = strdup(command_line);
	token = strtok(command_copy, DELIMITERS);
	while (token != NULL)
	{
		arguments[pos] = token;
		pos++;
		
		// allocates more memory to arguments if it gets filled
		if (pos >= buffer)
		{
			buffer += line_size;
			arguments = realloc(arguments, buffer * sizeof(char*));
			if (!arguments)
			{
				fprintf(stderr, "Error :: Problem with allocation");
				exit(-1);
			}
		}
		token = strtok(NULL, DELIMITERS);
	}
	
	// makes the last element in arguments a null pointer and returns it
	arguments[pos] = NULL;
	return arguments;
}

/**
 * @brief Executes a command based on the arguments provided
 * @param char **args - the command arguments
 * @return 1 if the operation was successful
 */
void execute (char **args, int background)
{
	pid_t pid = fork();
	
	// If pid is negative, an error has occurred
	if (pid < 0)
	{
		perror("Error :: Forked failed.");
		exit(-1);
	}
	// If pid is 0, a child process has been created
	if (pid == 0)
	{
		setsid();
		if (execvp(args[0], args) == -1)
			perror("Could not execute command");
		
		// An error has occurred if this instruction gets executed
		abort();
	}
	// if pid is not 0, than it is the pid of the child
	// If the process is in the background, the parent doesn't wait for it.
	else if (background == 0)
	{
		int status;
		waitpid(pid, &status, 0);
	}
}

/**
 * @brief Displays the command history
 */
void show_history()
{
	int count = command_count;
	int i = 0;
	int j = 0;
	
	// outputs the command history based on the command_count
	while (i < 10 && count > 0)
	{
		printf("%d: ", count);
		while (history[i][j] != '\n' && history[i][j] != '\0')
		{
			printf("%c", history[i][j]);
			j++;
		}
		printf("\n");
		j = 0;
		i++;
		count--;
	}
}

/**
 * @brief Updates the history with the newest command
 * @param char *command_line - the newest command to add
 */
void update_history(char *command_line)
{
	// Moves the commands up the history array to make room for the newest one
	for (int i = 9; i > 0; i--)
		strcpy(history[i], history[i - 1]);
		
	// Adds the latest command to the history array
	strcpy(history[0], command_line);
	command_count++;
}
