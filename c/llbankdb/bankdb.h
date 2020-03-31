/********************************************
* Filename: bankdb.h
* Author: Braydon Rekart (github.com/BRekart)
*********************************************
*/

#ifndef BANKDB_H
#define BANKDB_H

#define ACCTDELIM "-----"
#define FIELDDELIM '\t'
#define CHECKING "Checking"
#define SAVINGS "Savings"
#define DBFILE "./bank.db"

typedef struct Account {
    char * owner;
    char * type;
    struct Tx* firstTx; // holds pointer to the first Tx for a given Account
    } Account;

enum Tx_type {
    CREDIT, DEBIT
};

typedef struct Tx {
    enum Tx_type type;
    double amt;
    struct Tx* next;
    } Tx;

Account new_checking(char * owner);
Account new_savings(char * owner);
double get_Balance(Tx * list);
void debit(Account * acct, double amount);
void credit(Account * acct, double amount);
void print(Account acct);
void write(Account * accts, int count);
void read(Account ** accts, int * count);

#endif

