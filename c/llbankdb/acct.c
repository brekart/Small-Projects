#include <stdio.h>
#include <stdlib.h>
#include "bankdb.h"

//3/13 - 9am-12pm, 4-6pm,
// 3/14 - 9am - 12:38pm,
// 3/15 9am-12:30pm, 3-5pm,
Account new_checking(char * owner) {
    Tx* tempTx = (Tx*)malloc(sizeof(Tx));

    tempTx->type = CREDIT;
    tempTx->amt = 0.00;
    tempTx->next = NULL;

    Account tempAcct = { owner, CHECKING, tempTx };
    return tempAcct;
 }
 
 Account new_savings(char * owner) {
    Tx* tempTx = (Tx*)malloc(sizeof(Tx));

    tempTx->type = CREDIT;
    tempTx->amt = 0.00;
    tempTx->next = NULL;

    Account tempAcct = { owner, SAVINGS, tempTx };
    return tempAcct;
} 

 void debit(Account * acct, double amount) {
    Tx* tempTx = acct->firstTx;
    while (tempTx->next) {
        tempTx = tempTx->next;
    
    Tx* debit  = (Tx*)malloc(sizeof(Tx));
             
    debit->type = DEBIT;
    debit->amt = amount;
    debit->next = NULL;

    tempTx->next = debit;
    }
 }
 void credit(Account * acct, double amount){
    Tx* tempTx = acct->firstTx;
    while (tempTx->next) {
        tempTx = tempTx->next;
             

    Tx* credit = (Tx*)malloc(sizeof(Tx));

    credit->type = CREDIT;
    credit->amt = amount;
    credit->next = NULL;

    tempTx->next = credit;
  }
}
 double get_Balance(Tx * list) {
    double balance = 0.0;
    Tx* transaction = list->next;

    while (transaction != NULL) {
        if (transaction->type == CREDIT) {
            balance = balance + transaction->amt;
        } else {
            balance = balance - transaction->amt; 
        }
   }
   return balance;
}
 void print(Account acct){
    printf("Owner %s, Type: %s, Balance: %.2f\n", acct.owner, acct.type, get_Balance(acct.firstTx));

    Tx* transaction = acct.firstTx;
    while (transaction != NULL) {
        if (transaction->type == CREDIT) {
            printf("Tx_type: CREDIT, Amount: %.2f\n", transaction->amt);
        } else {
            printf("Tx_type: DEBIT, Amount: %.2f\n", transaction->amt);
        }
    transaction = transaction->next;
    }
 }
