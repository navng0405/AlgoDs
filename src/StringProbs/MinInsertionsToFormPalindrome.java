package StringProbs;

import java.util.HashMap;
import java.util.Map;

public class MinInsertionsToFormPalindrome {
    public static void main(String[] args) {
        String s1 = "moom";
        System.out.println(minInsertionsToFormPalindrome(s1)); // Output: 0

        String s2 = "leetcode";
        System.out.println(minInsertionsToFormPalindrome(s2)); // Output: 5
    }

    private static int minInsertionsToFormPalindrome(String givenString) {
        Map<Character,Integer> frequencyMap = new HashMap<>();

        for(char ch : givenString.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }
        int oddCount = 0;

        for(int count : frequencyMap.values()){
            if(count%2 ==1 ){
                oddCount++;
            }
        }
        return Math.max(oddCount-1,0);
    }
}
