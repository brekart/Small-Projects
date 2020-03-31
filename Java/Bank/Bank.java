/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.bank2;

/**
 *
 * @author braydon.rekart
 */
public class Bank {

    // Fields.
    private Account[] bankAccounts;

    // This prints out the account.
    public void printAccount(int arrayPosition, Account[] allAccounts) {
        System.out.println(allAccounts[arrayPosition]);
    }

    // This fills the array it creates with accounts.
    public void createAccounts() {
        Account[] allAccounts = new Account[10];
        //Savings.
        allAccounts[0] = new SavingsAccount(new Money("USD", 25), 0.5);
        allAccounts[1] = new SavingsAccount(new Money("USD", 50), 0.5);
        allAccounts[2] = new SavingsAccount(new Money("USD", 75), 0.5);
        allAccounts[3] = new SavingsAccount(new Money("USD", 100), 0.5);
        allAccounts[4] = new SavingsAccount(new Money("USD", 125), 0.5);
        //Checking.
        allAccounts[5] = new CheckingAccount(new Money("USD", 150));
        allAccounts[6] = new CheckingAccount(new Money("USD", 510));
        allAccounts[7] = new CheckingAccount(new Money("USD", 175));
        allAccounts[8] = new CheckingAccount(new Money("USD", 200));
        allAccounts[9] = new CheckingAccount(new Money("USD", 225));
        this.bankAccounts = allAccounts;
    }

    //This returns the account array for outside access.
    public Account[] getAccounts() {
        return bankAccounts;
    }

    // This gets the account at a specific array.
    public Account getIndex(int index) {
        return bankAccounts[index];
    }

}


// 
