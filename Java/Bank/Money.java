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
public class Money {

    // Fields.
    private final String currency;
    private final double amount;

    // Constructor.
    public Money(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    // Getters.
    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    // Adds/subtracts money.
    public Money add(Money m) {
        return new Money(this.currency, this.getAmount() + m.getAmount());
    }

    public Money subtract(Money m) {
        return new Money(this.currency, this.getAmount() - m.getAmount());
    }

    // Overrides toString.
    public String toString() {
        return this.currency + " " + this.amount;
    }

}
