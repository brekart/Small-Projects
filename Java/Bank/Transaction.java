/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.bank2;

/**
 *
 * @author Braydon
 */
public class Transaction {

    // Fields.

    private Money amount;
    private int numberTransactions;

    // Transaction constructor.

    public Transaction(Money m) {
        this.amount = m;
        this.numberTransactions++;
    }

    // Gets the number of transactions.

    public int getNumberTransactions() {
        return numberTransactions;
    }

    // Returns amount.

    public Money getAmount() {
        return amount;
    }

    // This sets the amount within this object.

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    // Overrides toString.

    @Override
    public String toString() {
        return "Transaction #" + numberTransactions + " " + "amount " + amount;
    }

}
