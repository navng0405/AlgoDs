package SystemDesign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static String toMD5(String input) {
        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Perform the hashing
            byte[] digest = md.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Return the hashed text
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "19228202";
        String md5Hash = toMD5(input);
        System.out.println("Original: " + input);
        System.out.println("MD5 Hash: " + md5Hash);
    }
}

