/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc4tea;

/**
 *
 * @author Braydon
 */
//Initialize array of 256 bytes
// Run KSA on them (key scheduling algorithm) (initializing the permutation)
// Run PRGA on KSA to generate keystream
// XOR the data with the keystream
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
import java.math.BigInteger;

public class RC4 {

    byte[] lookUpTable = new byte[256]; // S
    byte[] key = new byte[256];
    byte[] initializedKey = new byte[256]; // key
    byte[] keyStream;
    byte keyStreamByte;
    boolean generatingOutput;
    byte[] plaintext;
    byte[] keyTest;
    byte[] ciphertext;
    //int key;
    // keylength is number of bytes in key
    int keylength = 256;
    StringBuilder sb = new StringBuilder();

    public RC4(int key) {
        convertKey(key);
        KSA();
        PRGA();

    }

    public byte[] acceptMessage(String message) {
        convertMessageToBinary(message);
        return plaintext;

    }

    // Testing stackOverflow advice below, could be incorrect encryption
    public byte[] encrypt2(byte[] plaintext) {
        final byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        byte tmp;
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + initializedKey[i]) & 0xFF;
            tmp = initializedKey[j];
            initializedKey[j] = initializedKey[i];
            initializedKey[i] = tmp;
            t = (initializedKey[i] + initializedKey[j]) & 0xFF;
            k = initializedKey[t];
            ciphertext[counter] = (byte) (plaintext[counter] ^ k);
        }
        return ciphertext;
    }

    public byte[] decrypt2(byte[] ciphertext) {
        byte[] plaintext = encrypt2(ciphertext);
        return plaintext;
    }

    public byte[] getCipherText() {
        return ciphertext;
    }

    public String convertBytesToString(byte[] test) {
        String testString = Arrays.toString(test);
        return testString;
    }

    public String convertByteArrayToString(byte[] bytes) {

        Charset UTF_8 = Charset.forName("UTF-8");

        String byteArrayToString = new String(bytes, UTF_8);
        return byteArrayToString;
    }

    public String convertMessageToBinary(String message) {
        // http://stackoverflow.com/questions/917163/convert-a-string-like-testing123-to-binary-in-java
        byte[] bytes = message.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        //System.out.println("'" + message + "' to binary: " + binary);
        plaintext = binary.toString().getBytes();
        return binary.toString();
    }

    public byte[] getPlaintextBytes() {
        return plaintext;
    }

    // Error encountered with this: nullpointerexception. Seems plaintext array
    // is not being filled somehow.
    public void testArrays() {
        System.out.println(plaintext.toString());
    }

    // Call KSA then PRGA
    public void KSA() {
        // uses identity permutation while also converting to bytes
        // then must process S
        for (int k = 0; k < 256; k++) {
            lookUpTable[k] = (byte) k;
        }
        // now processing permutation of array
        int j = 0;
        int tempOne = 0;
        int tempTwo = 0;
        for (int k = 0; k < 256; k++) {
            j = (j + lookUpTable[k] + initializedKey[k % keylength]) & 0xFF;
            // Switching S[i] and S[j]
            byte tmp;
            for (int i = 0; i < 256; i++) {
                j = (j + lookUpTable[i] + initializedKey[i]) & 0xFF;
                tmp = lookUpTable[j];
                lookUpTable[j] = lookUpTable[i];
                lookUpTable[i] = tmp;

            }
        }
    }

    public void PRGA() {
        int i = 0;
        int j = 0;
        int counter = 0;
        byte tmp;

        while (counter < keylength) {
            i = (i + 1) % 256;
            j = (j + lookUpTable[i]) & 0xFF;
            for (int k = 0; k < 256; k++) {
                j = (j + lookUpTable[i] + initializedKey[i]) & 0xFF;
                tmp = lookUpTable[j];
                lookUpTable[j] = lookUpTable[i];
                lookUpTable[i] = tmp;
            }

            int keyStreamByteTemp = ((lookUpTable[i] + lookUpTable[j]) & 0xFF);

            try {
                keyStreamByte = lookUpTable[keyStreamByteTemp];
                String hexKeyStreamByte = (String.format("%02x", keyStreamByte));
                String hexToBinary = hexToBinary(hexKeyStreamByte);
                sb.append(hexToBinary);
                // following line prints out our keystream in binary to test
                // System.out.println(sb.toString());

            } catch (IndexOutOfBoundsException exception) {
                System.out.println(keyStreamByte + " has given an exception");
            }

            counter++;
        }
        //System.out.println("keystream binary: " + sb.toString());
        keyTest = sb.toString().getBytes();
    }

    public byte[] getBytedKey() {
        // System.out.println(keyTest);
        return keyTest;
    }
    // Following hexToBinary from
    // http://stackoverflow.com/questions/8640803/convert-hex-string-to-binary-string

    public String hexToBinary(String hex) {
        int i = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(i);
        return bin;
    }

    public void convertKey(int key) {
        // call this first. it gives us our key.
        int nonByte = key;
        byte bytedKey = (byte) key;
        // We create an int array and from it we initialize our key byte array
        int[] data = IntStream.generate(() -> bytedKey).limit(256).toArray();
        for (int i = 0; i < 256; i++) {
            initializedKey[i] = (byte) data[i];

        }
        keylength = countEach(key);
        //System.out.println("initialized key:" + initializedKey);
    }

    public int countEach(int num) {
        int result = 0;

        while (num != 0) {
            if (num % 2 == 1) {
                result++;
            }
            num = num / 2;
        }

        return result;
    }

    public String encryptMessage(String plaintext) {
        byte[] stringIntoByteArray = plaintext.getBytes();
        byte[] ciphertextBytes = encrypt2(stringIntoByteArray);
        String ciphertext = convertByteArrayToString(ciphertextBytes);
        return ciphertext;
    }

    public String decryptMessage(byte[] ciphertext) {

        byte[] messageToDecrypt = decrypt2(ciphertext);
        String decryptedMessage = convertByteArrayToString(messageToDecrypt);
        return decryptedMessage;
    }

    public static void main(String[] args) {
        RC4 RC4 = new RC4(33);

        String pt = "yih";
        String encrypted = RC4.encryptMessage(pt);
        String decrypted = RC4.decryptMessage(encrypted.getBytes());
        System.out.println(encrypted + decrypted);
        System.out.println(pt);

    }
}
