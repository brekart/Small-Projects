package braydon.rekart.rc4tea;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class TEA {

    BigInteger[] K = new BigInteger[]{new BigInteger("319480393"), new BigInteger("0056929269"),
        new BigInteger("2194642297"), new BigInteger("8916930267")}; //128 bit key
    private String merge;
    private final BigInteger delta = new BigInteger("9e3779b9", 16);
    private BigInteger sum = new BigInteger("0");

//Encrypts the Plaintext
    public BigInteger encrypt(BigInteger plainText, BigInteger[] key) {

        K = key;

        String pt = plainText.toString();
        BigInteger L = new BigInteger(pt.substring(0, pt.length() / 2));
        BigInteger R = new BigInteger(pt.substring(pt.length() / 2, pt.length()));

        for (int i = 0; i < 32; i++) {
            sum = sum.add(delta);
            L = L.add((R.shiftLeft(4).add(K[0])).xor(R.add(sum)).xor(R.shiftRight(5).add(K[1])));
            R = R.add((L.shiftLeft(4).add(K[2])).xor(L.add(sum)).xor(L.shiftRight(5).add(K[3])));
        }
        merge = L.toString() + R.toString();
        BigInteger cipherText = new BigInteger(merge);
 
        return cipherText;

    }

    // use this to convert key
    public BigInteger[] stringToBigIntArray(String contents) {

        BigInteger[] B_array = new BigInteger[contents.length() / 3];      // <<<<< have to new these ones
        int i = 0;
        for (int x = 0; x <= contents.length() - 3; x += 3) {                        // x <= instead of x <
            B_array[i] = new BigInteger(contents.substring(x, x + 3));
            i++;
        }
        return B_array;
    }


    public BigInteger decrypt(BigInteger cipherText, BigInteger[] key) {

        
        String pt = cipherText.toString();
        BigInteger L = new BigInteger(pt.substring(0, pt.length() / 2));
        BigInteger R = new BigInteger(pt.substring(pt.length() / 2, pt.length()));
        sum = delta.shiftLeft(5);
        for (int i = 0; i < 32; i++) {
            R = R.subtract((L.shiftLeft(4).add(K[2])).xor(L.add(sum)).xor(L.shiftRight(5).add(K[3])));
            L = L.subtract((R.shiftLeft(4).add(K[0])).xor(R.add(sum)).xor(R.shiftRight(5).add(K[1])));
            sum = sum.subtract(delta);
        }
        merge = L.toString() + R.toString();
        BigInteger plainText = new BigInteger(merge);
        return plainText;
    }

    public static void main(String[] args) {
        TEA t = new TEA();

        Scanner in = new Scanner(System.in);
        System.out.println("Put in plaintext: ");
        String plainText = in.nextLine();
        System.out.println("Plaintext: " + plainText);

        byte[] ar = plainText.getBytes();
                BigInteger bi = new BigInteger(ar);
                
        System.out.println("Please enter key: ");
        System.out.println("Eg: 8916930267891693026789169302678916930267");
        
       String key = in.next();
       BigInteger [] keyCode = t.stringToBigIntArray(key);
       
               BigInteger cipherText = t.encrypt(bi, keyCode);
               
               BigInteger cipherTextDecrypted = t.decrypt(cipherText, keyCode);
               byte[] ar1 = cipherTextDecrypted.toByteArray();
               System.out.println(Arrays.toString(ar1));
               

       
      
    }

}
