#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "avg.h"

int main() {
    int count = ASIZE;
    float * arr = (float *) malloc(sizeof(float) * count);
    get_input(&arr, &count);
   // printf("%d", count);
   // added in print line to help with gdb
    float av = avg(arr, count);
//    printf("%f", av);
//    added in print line to help with gdb
    printf("average of %d numbers: %.2f\n", count, av);
    free(arr);
    return 0;
    // placed free(arr) here
}

void get_input(float ** arr, int * count) {
    int curr = 0;
    size_t chars = 34;
    char * input_c = malloc(sizeof(char) * chars);
        while(1) {
              printf("Enter a number (blank to stop): ");
              getline(&input_c, &chars, stdin);
              if(! strcmp(input_c, "\n")) break;
              float input_f = atof(input_c);
              (*arr)[curr++] = input_f;
         }
                        *count = curr;
                        free(input_c);
                        // placed free(input_c) here
}

float avg(float * arr, int count) {
    float sum = 0;
    for(int i = 0; i < count; i++) {
           sum += arr[i];
           printf("element %d: %.2f\n", i, *(arr + i));
    }
           printf("sum = %.2f\n", sum);
           // changed count/sum to sum/count to fix
           // number being too small
                    return sum/count;
}

float * embiggen(float * arr, int * count) {
     int new_count = *count + ASIZE;
     float * new_arr = (float *) malloc(sizeof(float) * new_count);
           for(int i = 0; i < *count; i++) {
               new_arr[i] = arr[i];
           }
     *count = new_count;
     return new_arr;
     free(new_arr);
     // placed free(new_arr); here
}
