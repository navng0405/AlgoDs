package StringProbs;

import java.util.*;

public class PalindromePermutations {

    // Utility function to check if a palindrome permutation is possible and prepare the string for permutations
    private static String prepareString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        String mid = "";
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (!mid.isEmpty()) return null; // More than one character with odd count
                mid = "" + (char) (i + 'a');
            }
            for (int j = 0; j < count[i] / 2; j++) {
                half.append((char) (i + 'a'));
            }
        }
        return half + mid + half.reverse();
    }

    // Function to print all palindrome permutations
    public static void printPalindromePermutations(String s) {
        s = prepareString(s);
        if (s == null) {
            System.out.println("Palindrome permutations not possible.");
            return;
        }
        permute(s, 0, s.length() / 2);
    }

    // Utility function to generate permutations
    private static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i < r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i); // backtrack
            }
        }
    }

    // Helper function to swap characters in a string
    private static String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String s = "aabbc";
        printPalindromePermutations(s);
    }
}

