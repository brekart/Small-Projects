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
public class Loan extends Transaction {

    // Fields.
    private Money amount;
    private double intRate;
    double credit;

    // Loan constructor.
    public Loan(Money m) {
        super(m);
        credit = m.getAmount();
    }

    // This makes a payment on the loan.
    public void loanPayment(double payment) {
        credit = credit + payment;
    }

    // This gets the current loan amount needed to pay off.
    public double getCurrentLoan() {
        return credit;
    }

    // Overriding toString.
    @Override
    public String toString() {
        return "Loan amt: " + this.getAmount();
    }
}
