/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212.sp16.rekart.linkedlist;

/**
 *
 * @author braydon.rekart/dakota.vanwormer
 */
//Started: 2:00- finished 5.
public class Runner {

    // Here we create a new list and pass accounts into it.
    public static void main(String[] args) {
        LinkedList aList = new LinkedList();
        Account acc = Account.getRandom();
        Account acc2 = Account.getRandom();
        Account acc3 = Account.getRandom();
        Account acc4 = Account.getRandom();
        aList.add(acc);
        aList.add(acc2);
        aList.add(acc3);
        aList.add(acc4);
// Test code that prints out the list.
        System.out.println("First account: " + aList.getFirst().getAccount().getId());
        ListElement tempAcc = aList.getFirst();
        System.out.println("Printing list: ");
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i).getId());
        }
        System.out.println("Size: " + aList.size());
        
        if (aList.contains(acc)) {
            System.out.println("List contains " + acc.getId());
        } else {
            System.out.println("List does not contain " + acc.getId());
        }
        System.out.println("The position of acc is: " + aList.find(acc));
        System.out.println("Getting acc:" + aList.get(1).getId());
        System.out.println("Deleting account 1: ");
        aList.delete(1);
        aList.delete(acc);
        
        System.out.println("Printing list:");
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i).getId());
        }
        System.out.println("Size: " + aList.size());

    }
}
