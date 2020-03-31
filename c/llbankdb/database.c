#include <stdio.h>
#include <stdlib.h>
#include "bankdb.h"

void write(Account * accts, int count) {
    FILE * fp;
    fp = fopen(DBFILE, "w");
    if (!fp) {
        printf("Cannot open file %s\n", DBFILE);
        exit(1);
    }

    for (int i = 0; i < count; i++) {
        fprintf(fp, "%s\n", ACCTDELIM);
        fprintf(fp, "%s%c%s\n", accts[i].owner, FIELDDELIM, accts[i].type);

		
		Tx* tempVar = accts[i].firstTx;
        Tx* next = tempVar->next;
        while (next != NULL) {
            fprintf(fp, "%c%c%.2f\n", next->type, FIELDDELIM, next->amt);
            Tx* next = next->next;
        } 
        fprintf(fp, "%s", ACCTDELIM);
	}

fclose(fp);

}

void read(Account ** accts, int * count) {

    FILE * fp;
    fp = fopen(DBFILE, "r");

    if (!fp) {
        printf("Cannot open file %s\n", DBFILE);
    }

    int accountarraysize = 10;
    Account * acctarray = (Account *) malloc(sizeof (Account) * accountarraysize);
    int acctCount = 0;

    char * acctbuffer = NULL;
    size_t bufsize = 0;
    ssize_t readStatus;


    // reads up to acctdelim, stores in acctbuffer, stores # chars added to
    // acctbuffer in bufsize, moves fp to start at first char after delim
    getdelim(&acctbuffer, &bufsize, ACCTDELIM, fp);

    // getdelim returns -1 if fp points to EOF marker

    while ((readStatus = getdelim(&acctbuffer, &bufsize, ACCTDELIM, fp)) != -1) {
        if (acctCount != 10) {
        
        char * secAcctBuffer = NULL;
        size_t secBufSize = 0;
        ssize_t secStatus;
        char * owner;
        char * type;
    // cant use getdelim with char *
        owner = getdelim(&secAcctBuffer, &secBufSize, FIELDDELIM, acctbuffer);
        type = getdelim(&secAcctBuffer, &secBufSize, FIELDDELIM, acctbuffer);
        
        if (type = CHECKING) {
        acctarray[acctCount] = new_checking(owner);
        }
    
        if (type = SAVINGS) {
        acctarray[acctCount] = new_savings(owner);
        }
        acctCount++;
        }
    }

        char * thirdAcctBuffer = NULL;
        size_t thirdBufSize = 0;
        ssize_t thirdStatus;

    while ((thirdStatus = getdelim(&thirdAcctBuffer, &thirdBufSize, "\n", acctbuffer)) != -1 ){
        // try using sscanf to grab tx type and amount
        // by converting char* into int or double
        double amtScanned;
        char * typeScanned;

        double amt = sscanf(acctbuffer, "%d", amtScanned);
        char * type = sscanf(acctbuffer, "%s", typeScanned);
            
        // below should be credit/debit(acctarray[acctCount] but it
        // gives an incompatible type error        
        if (type = CREDIT) {
            credit(acctarray, amt);
        }
        if (type = DEBIT) {
            debit(acctarray, amt);
        }
    }
    fclose(fp);

    accts = acctarray;
    count = acctCount;
}
