 /******************************************** 
 * Filename: main.c
 * Author: Braydon Rekart (github.com/BRekart)
 *********************************************
 */

#include <stdio.h>
#include <stdlib.h>
#include "bankdb.h"
#include "acct.c"
#include "database.c"

int main(void) {
    printf("Creating 3 new accounts...");
    Account theAccounts[3];
    theAccounts[0] = new_checking("Drew Hans");
    theAccounts[1] = new_checking("Arthur Levan");
    theAccounts[2] = new_savings("Lucas Burdell");
    printf("Account creation successful!\n");
    printf("\n");

    print(theAccounts[0]);
    print(theAccounts[1]);
    print(theAccounts[2]);
    printf("\n");
	
	credit(&(theAccounts[0]), 999.99);
	
	debit(&(theAccounts[2]), 5000.01);

	write(theAccounts, 3);

    Account accountArray[1];
    int numAccounts = 1;
    read(accountArray, &numAccounts);
    print(accountArray[0]);
    print(accountArray[1]);
    print(accountArray[2]);

}
