/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.problems.fileprocessing;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyvu
 */
public class HashingEncrypter {

    // Declare names of hashing algorithms
    public static final String SHA_256 = "SHA-256";

    // Declare Unicode Character set
    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * Get encrypted result from byte-based input
     *
     * @param algorithmName: choose of your hashing algorithm
     * @param input:         the input byte array
     * @return the byte array after digesting
     */
    private static byte[] getDigest(String algorithmName,
                                    byte[] input) {
        try {
            // Create hashing encrypt object
            final MessageDigest digest = MessageDigest.getInstance(algorithmName);
            byte[] result = digest.digest(input);
            return result;

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Convert a byte array to a hexadecimal array and to string
     */
    private static String bytesToHex(byte[] bytes) {

        // Using StringBuilder for containing digits
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {         // Convert each byte to 2 hexa digits
            String apart = String.format("%02x", b);
            sb.append(apart);       // Add to the result
        }

        return sb.toString();
    }

    /**
     * Encrypt a source string using a hash method
     */
    public static String getHexaDigest(String algorithmName,
                                       String src) {
        // handling the emtpy src
        if (src.isBlank()) {
            throw new RuntimeException("The line is empty, hashing cannot be done.");
        }

        // convert Unicode source string to bytes
        byte[] srcBytes = src.getBytes(UTF_8);

        // create encrypting bytes from input bytes
        byte[] encryptingBytes = getDigest(algorithmName, srcBytes);

        // convert encrypting bytes ro hexadecimal string
        return bytesToHex(encryptingBytes);
    }

    /**
     * Output the hashed string representation
     *
     * @param msg:  type of hashing hashing function (e.g. SHA256, etc.)
     * @param data:
     */
    public static void output(String msg,
                              String data) {
        System.out.println(msg + ": " + data + "\nLen=" + data.length());
    }

    public static void main(String[] args) {

        // output source
        String userPwd = "VU KIM DUY";
        int len = userPwd.length();
        output("Source", userPwd);

        // output hashed source
        String sha256Str = HashingEncrypter.getHexaDigest(HashingEncrypter.SHA_256, userPwd);
        output("SHA256", sha256Str);
    }
}
