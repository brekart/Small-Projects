#include <stdio.h>
#include <stdlib.h>
#include "bankdb.h"

int main() {
    int num = 2;

    Account * accounts = (Account *) malloc(sizeof(Account) * num);
    accounts[0] = new_checking("braydon");
    accounts[1] = new_savings("bobby");
    print(accounts, num);
    write(accounts, num);
    print(accounts, num);
    read(&accounts, &num);
    print(accounts, num);
}

void print(Account * account, int num) {
    printf("All %d Accounts:\n", num);
    for (int i = 0; i < num; i++) {
        printf("%s's ", account[i].owner);
        printf("%s: ", account[i].type);
        printf("$%.2f", account[i].balance);
        printf("\n");  
    }
}

Account new_checking(char * owner) {

    Account new_checking;
    new_checking.owner = owner;
    new_checking.type = CHECKING;
    new_checking.balance = 0.0;

    return new_checking;
}

Account new_savings(char * owner) {

    Account new_savings;
    new_savings.owner = owner;
    new_savings.type = SAVINGS;
    new_savings.balance = 0.0;

    return new_savings;
}

void debit(Account * acct, double amount) {
    acct->balance = (acct->balance - amount);
}

void credit(Account * acct, double amount){
    acct->balance = (acct->balance + amount);
}

void print_Account(Account acct){
    printf("Account Owner: " "%s", acct.owner);
    printf("Account Type: " "%s", acct.type);
    printf("Account Balance: " "%.2f", acct.balance);
}

void write(Account * accts, int count){
    FILE *fp;
    fp = fopen(DBFILE, "w");
    
    if (!fp) {
        printf("Cannot open file %s\n", DBFILE);
        exit(1);
    }

    for(int i = 0; i < count; i++) {
        fprintf(fp, "%s\n", ACCTDELIM);
        fprintf(fp, "%s%c%s\n", accts[i].owner, FIELDDELIM, accts[i].type);
    }

    fclose(fp);
}

void read(Account ** accts, int * count) {
    *count = 0;
    Account * acctarray = (Account *) malloc(sizeof(Account) * 10);

    //int acct_count = 0;
    char *buffer;
    size_t bufsize = 32;
    ssize_t characters;
    
    buffer = (char *) malloc(bufsize * sizeof(char));
    // open file for reading
    FILE *fp;
    fp = fopen(DBFILE, "r");
    if (!fp) {
        printf("Cannot open file %s\n", DBFILE);

    }
    int iteration = 0;
    // loop based on reading a char* with getline or getdelim
    while(characters > 0) {
        // determine what to do based on the contents of a line
        // populate the array
        characters = getline(&buffer, &bufsize, fp); 

//        char * actAry = (char *) malloc(sizeof(Account) * 10);
//        actAry[iteration] = characters;
//        iteration++;

        // put accts in array
        acctarray[iteration] = (Account *) &buffer;
        iteration++;
       
    }

    // close the file
    fclose(fp);    

   // *accts = acctarray;
}






