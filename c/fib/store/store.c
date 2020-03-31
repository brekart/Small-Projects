#include "stdio.h"
#include "stdlib.h"
#include "store.h"
// instance of struct, assign value and print

int main() {

Item item;

item.price = 500.0;
item.sku = 20735;

printf("Item price: " "%.2f", item.price);
printf("\n");
printf("Item SKU: " "%d", item.sku);

}
