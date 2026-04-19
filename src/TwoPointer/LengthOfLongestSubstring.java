package TwoPointer;

import java.util.*;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
