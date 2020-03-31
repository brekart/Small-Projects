#include <stdio.h>
#include <stdlib.h>

int main()
{
  char *p;

  // Allocation #1 of 19 bytes
  p = (char *) malloc(19);
  free(p);
  // Allocation #2 of 12 bytes
  p = (char *) malloc(12);
  free(p);

  int x = 0;
  printf("x = %d\n", x);

  int y [5];
  y[0] = 1;
  y[1] = 2;
  y[2] = 3;
  y[3] = 4;
  y[4] = 5;
  for (int i = 0; i < 5; i++) {
    printf("y[%d] = %d\n", i, y[i]);
  }

  // Allocation #3 of 16 bytes
  p = (char *) malloc(16);
  free(p);
  return 0;
}
