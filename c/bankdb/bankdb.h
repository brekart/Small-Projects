#ifndef BANKDB_H
#define BANKDB_H

 typedef struct  {

     char * owner;
     char * type;
     double balance;


 } Account;


 Account new_checking(char * owner);
 Account new_savings(char * owner);
 void debit(Account * acct, double amount);
 void credit(Account * acct, double amount);
 void print(Account * acct, int num);
 void write(Account * accts, int count);
 void read(Account ** accts, int * count);
 #define ACCTDELIM "-----"
 #define FIELDDELIM '\t'
 #define CHECKING "Checking"
 #define SAVINGS "Savings"
 #define DBFILE "bank.db"

 #endif
