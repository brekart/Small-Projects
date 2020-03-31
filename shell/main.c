#include <stdio.h>

const int NUM = 10;

int main(void) {

    int numbers[10];


    for(int i = 0; i < 10; i++) {
        printf("%d\n", numbers[i]);
    }

    for(int i = 0; i < 10; i++) {
        numbers[i] = NUM - i;
        printf("%d\n", numbers[i]);
    }

}
