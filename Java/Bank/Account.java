/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.bank2;

/**
 *
 * @author joshua.gross
 */
public abstract class Account {

    // Fields.
    private int numberOfTransactions;
    private Money balance;
    private int index;
    Transaction[] tArray = new Transaction[10];
    int whichAccount = 1;

    // Account constructor.
    public Account(Money balance) {
        this.balance = balance;
    }

    // This adds a transaction to the transaction array.
    public void addTransaction(Transaction tAction) {
        tArray[index] = tAction;
        index++;
    }

    // This gets the transaction at a specified index.
    public Transaction getTransaction(int index) {
        return tArray[index];
    }

    // This returns the array for outside access.
    public Transaction[] getTransactionArray() {
        return tArray;
    }

    // This loop prints the transactions.
    public void printTransactions() {

        for (int i = 0; i < tArray.length; i++) {
            if (tArray[i] == null) {
                break;
            } else {
                System.out.println(tArray[i]);
            }
        }
    }

    // This gets the current balance.
    public Money getBalance() {
        return this.balance;
    }

    // This takes money.
    protected final void debit(Money m) {
        this.balance = this.balance.subtract(m);
        this.addTransaction(new Transaction(m));
    }

    // This gives money.
    protected final void credit(Money m) {
        this.balance = this.balance.add(m);
        this.addTransaction(new Transaction(m));
    }

    // Abstract unused methods.
    public abstract void deposit(Money m);

    public abstract void withdraw(Money m);

    // Overriding toString.
    @Override
    public String toString() {
        return "CheckingAccount{" + "balance=" + balance + '}';
    }

}
