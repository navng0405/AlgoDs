package Array;

public class LongestPalindromicSubstring {

    private int start, maxLength;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            expandAroundCenter(s, i, i);  // Assume odd length, try to extend Palindrome as centered at i
            expandAroundCenter(s, i, i + 1); // Assume even length.
        }
        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLength < right - left - 1) {
            start = left + 1;
            maxLength = right - left - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input = "baboobad";
        System.out.println("Longest Palindromic Substring: " + solution.longestPalindrome(input));
    }
}

