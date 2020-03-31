#include <stdio.h>
#include "foo.h"



int main(void){

    void foo(int * y) {

        *y = 4;

    }


    int x = 5;
    foo(&x);
    printf("%d\n", x);

}
