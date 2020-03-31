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
public class LinkedList {
// Fields. First element is the first list object, current element is the current one.

    private ListElement firstElement;
    private ListElement currentElement;
    private int size = 0;

    // Constructor.
    public LinkedList() {

    }

    public Account getTest(int index) {
        return null;
    }
    // This returns the first element of the list.

    public ListElement getFirst() {
        return firstElement;
    }

    // This adds an account to the list.
    public void add(Account a) {
        ListElement listElement = new ListElement(a);
        if (this.firstElement == null) {
            firstElement = listElement;
            currentElement = listElement;
        } else {
            while (hasNext()) {
                getNext();
            }
            this.currentElement.setNextElement(listElement);
        }
        size++;
    }

    public void delete(Account del) {
        for (int i = 0; i < size(); i++) {
            while (this.hasNext()) {
                this.currentElement = this.currentElement.getNextElement();
            }
            if (get(i) == del) {
                this.currentElement = null;
            }
        }
    }

    public void delete(int in) {
        for (int i = 0; i < size(); i++) {
            //currentElement = currentElement.getNextElement();
            if (i == in) {
                this.currentElement = null;
            }
        }
    }

    public void insertBefore(int index) {

    }

    // This returns the size.
    public int size() {
        return size;
    }

    // This determines if the element has a next element.
    public boolean hasNext() {
        try {
            return (this.currentElement.getNextElement() != null);
        } catch (Exception NullPointerException) {
            System.out.println("Current element does not have next element.");
        }
        return false;
    }

    // This returns the next element.
    public Account getNext() {
        if (currentElement != null) {
            Account currentAccount = currentElement.getAccount();
            currentElement = currentElement.getNextElement();
            return currentAccount;
        } else {
            currentElement = firstElement;
            Account currentAccount = currentElement.getAccount();
            currentElement = currentElement.getNextElement();
            return currentAccount;
        }
    }

    public int find(Account a) {
        for (int i = 1; i < size(); i++) {
            if (currentElement.getAccount() == a) {
                return i;
            }
        }
        return -1;
    }

    public Account get(int in) {
        int index = 0;
        while (index != in && hasNext()) {
            getNext();
            index++;
        }
        currentElement = firstElement;
        return getNext();
    }

    public Account get2(int in) {
        for (int i = 0; i < size(); i++) {
            if (i == in) {
                return currentElement.getAccount();
            }
        }
        return null;
    }

    public boolean contains(Account a) {
        for (int i = 1; i < size(); i++) {
            if (this.currentElement.getAccount() == a) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "firstElement=" + firstElement + ", currentElement=" + currentElement + ", size=" + size + '}';
    }

}
