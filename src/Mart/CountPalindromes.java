package Mart;

import java.util.HashMap;
import java.util.Map;

public class CountPalindromes {
    public static int countPalindromes(String[] arr) {
        int n = arr.length;
        int maxPalindromes = 0;


        // Step 2: Determine potential palindromes
        for (String s : arr) {
            int oddCount = 0;
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            for (char c : countMap.keySet()) {
                if (countMap.get(c) % 2 != 0) {
                    oddCount++;
                }
            }
            // A string can be palindrome if it has at most one character with odd count
            if (oddCount <= 1) {
                maxPalindromes++;
            }
        }

        // Step 3: Adjust for maximum potential considering swaps
        // This step requires a deeper analysis of the character counts and their distribution
        // across strings to adjust the `maxPalindromes` count based on the possibility of swaps.

        return maxPalindromes;
    }

    public static void main(String[] args) {
        String[] arr = {"passp", "sas", "asps", "df"};
        System.out.println(countPalindromes(arr));
    }
}
