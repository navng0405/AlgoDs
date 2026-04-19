package StringProbs;

import Array.LongestPalindromicSubstring;

public class LongestPalindromicSubString {
    static int start=0;
    static int  maxLength = 0;
    public static void main(String[] args) {

        String input = "baboobad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }

    private static String longestPalindrome(String input) {

        for(int i=0;i<input.length();i++){
            expandOuterFromCenter(input,i,i);
            expandOuterFromCenter(input,i,i+1);
        }

        return input.substring(start,start+maxLength);
    }

    private static void expandOuterFromCenter(String input, int left, int right) {
        while(left >=0 && right <=input.length()-1 && input.charAt(left) == input.charAt(right)){
            left--;
            right++;
        }
        if(maxLength < right-left-1){
            start = left+1;
            maxLength = right-left-1;
        }
    }

}
