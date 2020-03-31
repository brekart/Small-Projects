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
public class CheckingAccount extends Account {

    // Extends account-- inherits all of Account's methods.
    // Constructor.
    public CheckingAccount(Money balance) {
        super(balance);
    }

    // Overrides the deposit and withdraw methods from Account.
    @Override
    public void deposit(Money m) {
        this.credit(m);
    }

    @Override
    public void withdraw(Money m) {
        this.debit(m);
    }

}
