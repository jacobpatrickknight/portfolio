/* 
 * Lab 3: Synchronization
 * Programmer Jacob Knight
 * Course: CMPE 320
 * Section: 1 (9:00-10:50am)
 * Instructor: S. Lee
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <math.h>

#define MAX 10000000

int points_in_circle = 0;

void *monte_carlo(void *);

int main (int argc, char** argv)
{
	pthread_t carloThread;		// thread identifier
	pthread_attr_t attr;		// set of thread attributes
	pthread_attr_init(&attr);	// gets the default attributes

	// creates the thread
	pthread_create(&carloThread, &attr, monte_carlo, NULL);

	// waits for the thread to exit
	pthread_join(carloThread, NULL);
	
	// outputs the approximation of pi
	printf("Approximation of Pi: ");
	double pi = 4 * points_in_circle / (double)MAX;
	printf("%f \n\n", pi);

	return 0;
}

// Randomly generates points and sees if they are within the circle
// Doesn't take parameters
void *monte_carlo (void *nothing)
{	
	// Generates a new seed for random numbers
	srand(time(NULL));
	
	// Creates random points and sees if they are within the circle
	for (int i = 0; i < MAX; i++)
	{
		// Creates random points
		double x = (rand() / (double)RAND_MAX) * 2.0 - 1.0;
		double y = (rand() / (double)RAND_MAX) * 2.0 - 1.0;
		
		// Determines if the points are on the circle
		double result = sqrt(pow(x, 2) + pow(y, 2));
		if (result < 1)
			points_in_circle++;
	}
}		