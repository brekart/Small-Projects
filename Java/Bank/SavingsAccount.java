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
public class SavingsAccount extends Account {
    // This double is the interest rate.
    private double intRate;
    // SavingsAccount constructor.
    public SavingsAccount(Money balance, double intRate) {
        super(balance);
        this.intRate = intRate;
    }
    // The following methods override the originals.
    @Override
    public void deposit(Money m) {

    }

    @Override
    public void withdraw(Money m) {

    }
    // This is to let us access the interest rate.
    public double getIntRate() {
        return intRate;
    }

    // Overrides toString.
    @Override
    public String toString() {
        return "SavingsAccount{" + "intRate=" 
                + intRate + '}' + "{balance=" + this.getBalance();
    }
    

}
