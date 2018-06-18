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
pthread_mutex_t lock;

void *monte_carlo(void *);

int main ()
{
	pthread_mutex_init(&lock,NULL);	// initializes the mutex lock
	
	pthread_t carloThread1;			// thread identifiers
	pthread_t carloThread2;		
	pthread_t carloThread3;		
	pthread_t carloThread4;		
	pthread_attr_t attr;			// set of thread attributes
	pthread_attr_init(&attr);		// gets the default attributes

	// creates the thread
	pthread_create(&carloThread1, &attr, monte_carlo, NULL);
	pthread_create(&carloThread2, &attr, monte_carlo, NULL);
	pthread_create(&carloThread3, &attr, monte_carlo, NULL);
	pthread_create(&carloThread4, &attr, monte_carlo, NULL);

	// waits for the thread to exit
	pthread_join(carloThread1, NULL);
	pthread_join(carloThread2, NULL);
	pthread_join(carloThread3, NULL);
	pthread_join(carloThread4, NULL);
	
	// outputs the approximation of pi
	printf("Approximation of Pi: ");
	double pi = 4 * points_in_circle / (double)MAX;
	printf("%f \n\n", pi);

	// deletes the mutex lock
	pthread_mutex_destroy(&lock);
	return 0;
}

// Randomly generates points and sees if they are within the circle
// Doesn't take parameters
void *monte_carlo (void *nothing)
{	
	// Generates a new seed for random numbers
	srand(time(NULL));
	int new_points = 0;
	
	// Creates random points and sees if they are within the circle
	// Points are added in a separate variable from points_in_circle
	for (int i = 0; i < (MAX / 4); i++)
	{
		// Creates points on a circle
		double x = (rand() / (double)RAND_MAX) * 2.0 - 1.0;
		double y = (rand() / (double)RAND_MAX) * 2.0 - 1.0;
		
		// Determines if the points are on the circle
		double result = sqrt(pow(x, 2) + pow(y, 2));
		
		if (result < 1)
			new_points++;
	}
	
	// Adds the total of new points to the existing points in the circle
	// Critical Section - only one thread may update points_in_circle at a time
	pthread_mutex_lock(&lock);
	points_in_circle += new_points;
	pthread_mutex_unlock(&lock);
}		