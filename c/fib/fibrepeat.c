#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include "fibrepeat.h"

// 4 hours 15 minutes - 9:16am 2/20
// 8 hours or so~ - 7:31pm 2/20
// 12 hours total - 11:47pm 2/21
// (no problem with this)

int * halfPointer(int * toChange, int * size){

    *size = (*size * .5);
    int * toChange_halved = (int *) malloc(*size * sizeof(int));
    return toChange_halved;
}

int main(int argc, char* argv[]) {

	if (argc <= 1) {

		printf("You did not enter a number.");
		exit(1);
	}

// adding in while loop logic

// user number passed in below
	int size = atoi(argv[1]);
    //pointer to array
    int * fib_seq = (int *) malloc(size * sizeof(int));
    *fib_seq = 0;

    if (fib_seq == NULL) {
         printf("No memory available. Exiting...");
         exit(1);
    }

    int n1 = 0, n2 = 1, n3;
    printf("initial sequence\n");
//    printf("%d %d", n1, n2); // printing 0 and 1
    for (int i = 0; i < size; i++) {
        
        n3 = n1 + n2;
        printf("%d", n3);
        fib_seq[i] = n3;
        n1 = n2;
        n2 = n3;
    }
    printf("\n");
    printf("\n");
    
//    printf("initial sequence\n");
//    for (int i = 2; i < size; i++) {
  //      printf("%d ", fib_seq[i]);
   // }
   // printf("\n");


    int limit = 0;

    while(limit < 10) {
        // doubling fib_seq
        int * toArray = doublePointer(fib_seq, &size);
        if(! toArray) {
            printf("not enough memory to give you %d elements\n", size);
           // printf("press ENTER to begin array reduction");
            break;
          // getchar();
           // now beginning REDUCTION logic? probably shouldnt go here
          //  int * toArray = halfPointer(fib_seq, &size);

           }
     //   } else sleep(2);
        duplicateIntoPointer(toArray, fib_seq, size);

        free(fib_seq);
        // need to assign array to fib-seq so it 
        // doubles next iteration correctly
        fib_seq = toArray;    
        limit++;

    }
        limit = 0;

        printf("press ENTER to begin array reduction");

        getchar();

        while(limit < 10) {
        int * toArray = halfPointer(fib_seq, &size);
        fillHalfPointer(fib_seq, toArray, size);
        limit++;
        }

        printf("\ninitial sequence\n");
        for (int i = 2; i < size; i++) {
        printf("%d ", fib_seq[i]);
    }
    printf("\n");
        free(fib_seq);
}
// main ends above
// now creating function to halve the size of int *

int * doublePointer(int * toChange, int * size) {
    *size = (*size * 2);
    int * toChange_doubled = (int *) malloc(*size * sizeof(int));
    return toChange_doubled;
}

void duplicateIntoPointer(int * toDupe, int * from, int size) {
    //printf("duplicated sequence\n");
    for (int i = 0; i < size; i++) {
        toDupe[i] = from[i%(size/2)];
        //printf("%d ", toDupe[i]);
    }
    printf("new size: %d\n", size);
    //printf("\n");
}

void fillHalfPointer(int * toFill, int * from, int size) {
   // int half = size/2;
    for (int i = 0; i < size; i++) {
     toFill[i] = from[i%size];
    }
    // above method is printing out some fibonacci, and some garbage
    printf("new size: %d\n", size);

}


