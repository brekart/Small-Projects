package edu.blackburn.cs.cs212sp16.rekart.bank2;

import java.util.Random;

/**
 *
 * @author joshua.gross
 */
public class Runner {

    // Estimated time: 6 hours.
    // STARTED AT 2:45PM 2/9.
    // Worked till 5:00pm.
    // Returned at 6:30pm.
    // Worked till 9:30pm.
    // Returned 2/10 at 8:30pm, began work.
    // Finished at 9:30pm.
    // Returned at 12:00pm on 2/13.
    // Worked till 12:45.
    // Started at 1. Finished assignment at 1:31.
    public static void main(String[] args) {
        // Creating the bank objects, accounts, and importing the accounts.
        Bank bank = new Bank();
        bank.createAccounts();
        bank.getAccounts(); // bankAccounts

        // This for loop prints the arrays and adds money to them. Each increment
        // of 25 lets you know it's the next account. 
        double moneyAdded = 1000.0;
        for (int i = 0; i < bank.getAccounts().length; i++) {
            System.out.println("Account " + (i + 1) + ": "
                    + bank.getIndex(i));
            bank.getIndex(i).credit(new Money("USD", moneyAdded));
            System.out.println("Account " + (i + 1) + "(after credit): "
                    + bank.getIndex(i));
            moneyAdded = moneyAdded + 25;
            System.out.println();

        }
        // This loop prints the transactions.
        System.out.println("//Currently 1 transaction in each account, hence"
                + " the repeated 1. Each increment of 25 USD is where"
                + " a new account begins-- there are 10. \n(Each account has"
                + " $25 more than the last.)//");
        for (int i = 0; i < bank.getAccounts().length; i++) {
            Account tempAccount = bank.getIndex(i);
            tempAccount.printTransactions();
        }
        // Loan time.
        System.out.println("Loan:");
        Loan loan = new Loan(new Money("USD", 10000));
        System.out.println(loan);
        //This loop will add payments, from 1-1000 at a time, onto the loan.
        // When no money is no longer owed, it will stop.
        int loanPaid = 0;
        while (loanPaid > -10000) {
            Random getMoney = new Random();
            int i = getMoney.nextInt(1000) + 1;
            System.out.println("Adding loan payment of: " + i);
            loanPaid = loanPaid - i;
            loan.loanPayment(-i);
            System.out.println("Loan remaining: " + loan.getCurrentLoan());
        }
    }
}
