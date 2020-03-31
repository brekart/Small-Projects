package edu.blackburn.cs.cs212.sp16.rekart.linkedlist;

import java.util.*;

/**
 * Objects of type Account represent accounts. What kind of accounts? The kind
 * that have an integer id. A positive integer id. Could be used as a base
 * class for tons of kinds of accounts. New Account objects cannot be created 
 * directly; use the static getRandom() method to get an Account object, but
 * beware that this method does not guarantee a new Account object.
 * 
 * Two Account objects with the same id are equal, and the equals() method 
 * supports this.
 * @author joshua.gross
 */
public class Account {
    
    private final int id;
    
    private static final Random RANDOM = new Random();
    
    private static final List EXTANT = new ArrayList();
    
    private static boolean LOG = false;
    
    /**
     * The maximum number of Account objects that can be created; set to
     * 1 million.
     */
    public static final int MAXSIZE = 1000000;
    

    /**
     * Private constructor, should never be called from outside of the class
     * @param id the id for the new Account object
     */
    private Account(int id) {
        this.id = id;
    }
    
    /**
     * Return the id attribute of the account
     * @return the id of the account (an int)
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Compares two objects. If the object passed in is of type Account
     * and its id is equal to this object's id, the two are equal, and 
     * the method returns true; otherwise it returns false
     * @param o the object to compare to this Account object
     * @return whether the two objects are equal (have the same id)
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Account) {
            Account a = (Account) o;
            if (a.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Randomly generates a new Account object, adds it to the EXTANT
     * List, and returns that Account object 2/3 of the time, or if 
     * MAXSIZE Account objects have been created. Otherwise returns a random 
     * existing Account object from the EXTANT List. Will never create 
     * duplicates.
     * @return a random Account object, possibly new (up to 2/3 of the time) 
     */
    public static Account getRandom() {
        // generate random number to decide if we create a new Account or return
        // an existing Account
        int makeNew = RANDOM.nextInt(3);
        
        // 1/3 of time, or if the max number of Account objects have been
        // created, return an existing Account object
        if((makeNew == 0 && EXTANT.size() > 0) || EXTANT.size() >= MAXSIZE) {
            int tmp = RANDOM.nextInt(EXTANT.size());
            Account a = (Account) EXTANT.get(tmp);
            if(LOG) System.err.println("Existing - Id: " + a.getId() + " Element: " + tmp);
            return a;
        } else if (EXTANT.size() < 1 || makeNew == 1 || makeNew == 2) {
            
            // 2/3 of the time, create a new Account object
            while(true){
                
                // generate random positive int between 0 and MAXSIZE
                int tmp = Math.abs(RANDOM.nextInt(MAXSIZE));
                
                // create new Account object
                Account a = new Account(tmp);
                
                // see if an equivalent object exists, and if so, restart loop
                // should use a hashmap for this for performance, but one step 
                // at a time
                if(EXTANT.contains(a)) {
                    if(LOG) System.err.println("Repeat: " + tmp);
                    continue;
                }
                
                // if the Account object is new, add it to the EXTANT List and
                // return to the caller
                EXTANT.add(a);
                
                if(LOG) System.err.println("New: " + tmp + " Total: " + EXTANT.size());
                return a;
            } 
        } else {
            
            // if the rng is not in the set {0, 1, 2}, we have a problem
            throw new RuntimeException("Random integer should be in set {0,1,2}, but is " + makeNew);
        }
    }
    
    /**
     * Turn on logging (defaulted to off)
     * DON'T USE THIS 
     * @param flag true for logging on, false for logging off
     */
    public static void log(boolean flag) {
        LOG = flag;
    }
    
}