/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braydon.rekart.rc4tea;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * 
 */
public class RC4TEA {
    // Declaring ciphers

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome. Please enter a cipher: ");
        System.out.println("RC4 / TEA");

        String selectedCipher = in.nextLine().toUpperCase();

        if (!"RC4".equals(selectedCipher.toUpperCase())
                & !"TEA".equals(selectedCipher.toUpperCase())) {
            System.out.println("You have entered an invalid cipher.");
            System.exit(0);
        }

        System.out.println("Selected cipher: " + selectedCipher.toUpperCase());
        System.out.println("Would you like to encrypt or decrypt?");
        System.out.println("Enter E for encrypt or D for decrypt.");

        String selectedMode = in.nextLine().toUpperCase();

        // RC4
        if ("RC4".equals(selectedCipher) & "E".equals(selectedMode)) {
            String hexKeyEncrypt;
            String plainTextEncrypt;

            System.out.println("Please enter a key: ");
            System.out.println("Note: Key must be a hexidecimal number"
                    + " between 8-256 bits and"
                    + " evenly divisible by 8. Ex: 3264f");

            hexKeyEncrypt = in.nextLine();

            int key = Integer.parseInt(hexKeyEncrypt.trim(), 16);

            if (key % 8 == 0) {
                System.out.println("You have entered an invalid key.");
            } else {

                RC4 RC4 = new RC4(key);
                System.out.println("Please enter plaintext: ");
                plainTextEncrypt = in.nextLine();
                String cipherText = RC4.encryptMessage(plainTextEncrypt);

                String encodedCipher
                        = DatatypeConverter.printBase64Binary(cipherText.getBytes());
                System.out.println("Base 64 Ciphertext: " + encodedCipher);
            }
        }

        if ("RC4".equals(selectedCipher) && "D".equals(selectedMode)) {

            String hexKeyDecrypt;
            String cipherTextDecrypt;

            System.out.println("Please enter a key: ");
            System.out.println("Note: Key must be a hexidecimal number"
                    + " between 8-256 bits and"
                    + " evenly divisible by 8. Ex: 3264f");

            hexKeyDecrypt = in.nextLine();

            int keyTwo = Integer.parseInt(hexKeyDecrypt.trim(), 16);

            if (keyTwo % 8 == 0) {
                System.out.println("You have entered an invalid key.");
            } else {

                RC4 RC4 = new RC4(keyTwo);
                System.out.println("Please enter ciphertext: ");
                cipherTextDecrypt = in.nextLine();

                byte[] decodedCipher
                        = DatatypeConverter.parseBase64Binary(cipherTextDecrypt);

                String decodedPlain = RC4.decryptMessage(decodedCipher);

                System.out.println("Base 64 Plaintext: " + decodedPlain);
            }
        }

        // TEA
        if ("TEA".equals(selectedCipher) && "E".equals(selectedMode)) {
            String hexKeyEncrypt;
            String plainTextEncrypt;

            System.out.println("Please enter a key: ");
            System.out.println("Note: Key must be a hexidecimal number,"
                    + " 128 bits and"
                    + " evenly divisible by 8. Ex: 8916930267891693026789169302678916930267");

            hexKeyEncrypt = in.nextLine();

            hexKeyEncrypt = hexKeyEncrypt.trim();

            BigInteger key = new BigInteger(hexKeyEncrypt, 16);
            String mod = "8";
            BigInteger modBI = new BigInteger(mod);

            if (key.mod(modBI).equals(0)) {
                System.out.println("You have entered an invalid key.");
            } else {

                byte[] bytes = key.toByteArray();
                System.out.println(Arrays.toString(bytes));

                //TEA3 TEA3 = new TEA3(bytes);
                // TEA ORIGINAL
                TEA TEA = new TEA();
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter plaintext: ");
                String test = input.nextLine();

                byte[] ar = test.getBytes();
                BigInteger bi = new BigInteger(ar);
                BigInteger[] keyCode = TEA.stringToBigIntArray(hexKeyEncrypt);

                String cipherText = new String(TEA.encrypt(bi, keyCode).toByteArray());
                String encodedCipher = DatatypeConverter.printBase64Binary(cipherText.getBytes());
                System.out.println("Ciphertext: " + encodedCipher);

            }

        }

        if ("TEA".equals(selectedCipher) && "D".equals(selectedMode)) {

            String hexKeyDecrypt;
            String cipherTextDecrypt;

            System.out.println("Please enter a key: ");
            System.out.println("Note: Key must be a hexidecimal number,"
                    + " 128 bits and"
                    + " evenly divisible by 8. Ex: 8916930267891693026789169302678916930267");

            hexKeyDecrypt = in.next();

            hexKeyDecrypt = hexKeyDecrypt.trim();

            BigInteger key = new BigInteger(hexKeyDecrypt, 16);
            String mod = "8";
            BigInteger modBI = new BigInteger(mod);

            if (key.mod(modBI).equals(0)) {
                System.out.println("You have entered an invalid key.");
            } else {
                TEA TEA = new TEA();
                //  byte[] ar = cipherText.getBytes();
                //System.out.println(Arrays.toString(ar));
                System.out.println("Please enter ciphertext: ");
                String cipherText = in.next();
// plaintext -> byte ar of getbytes of string, biginteger from the byte arrtay, string
                // of cipher from tea.encrypt, then encode
                 byte[] decodedCipher
                        = DatatypeConverter.parseBase64Binary(cipherText);
                 
                 BigInteger test = new BigInteger(decodedCipher);
                BigInteger[] keyCode = TEA.stringToBigIntArray(hexKeyDecrypt);
//                 
                 BigInteger decodedPlain = TEA.decrypt(test, keyCode);
                 //Exception in thread "main" java.lang.NumberFormatException: Illegal embedded sign character
//	at java.math.BigInteger.<init>(BigInteger.java:419)
//	at java.math.BigInteger.<init>(BigInteger.java:597)
//	at rc4tea.TEA.decrypt(TEA.java:63)
//	at rc4tea.RC4TEA.main(RC4TEA.java:184)
//Java Result: 1
                 byte[] decodedPlainArray = decodedPlain.toByteArray();
                 
                 System.out.println(decodedPlainArray.toString());
//                 
//                 byte[] cipherDecoded = DatatypeConverter.parseBase64Binary(cipher);
//                 
//                 String cipherDecodedString = cipherDecoded.toString();
//                 System.out.println(cipherDecoded.toString());
//                 
//                
//                BigInteger bi = new BigInteger(decodedCipher);

                
                // print out ciphertext?
// JhPvv71s77+9YTTvv73vv71ENe+/vTNnVXISBu+/ve+/vTnvv73vv73vv73vv70x77+977+9USxl77+977+9Imjvv71W77+9Ce+/vXQ2ODp5Nu+/vdSebyLvv73vv70WAAMe77+9G++/vRDvv70RQyTvv73vv73vv73vv70=


            }

        }

    }
}
