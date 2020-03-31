

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {

    srand(time(NULL));

    int random = rand() % 20;
    int choice;


    int bytes_read;
    size_t nbytes = 100;
    char *user_guess;

   while(choice != random) { 
    puts ("Please enter a number between 1-20: ");
      user_guess = (char *) malloc (nbytes + 1); 
      bytes_read = getline (&user_guess, &nbytes, stdin);
      choice = atoi(user_guess);

    if (choice == random) {
        puts("Correct!");
    }

    if (choice < random) {
        puts("Too low!");
    }

    if (choice > random) {
        puts("Too high!");
    }
  }
}

