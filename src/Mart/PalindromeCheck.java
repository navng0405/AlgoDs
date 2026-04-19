package Mart;

/**
 * Given a strings, return true if the s can be palindrome after deleting at most one character from it.
 * Example 1:
 * Input: s = "'aba"
 * Output: true
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 * Input: s = "abc"
 * Output: false
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        String givenString = "abca";
        System.out.println("Is given String is palindrom :" + validPalindrome(givenString));
    }
    private static boolean validPalindrome(String str){
        int left=0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return checkPalindrome(str,left+1,right) || checkPalindrome(str,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkPalindrome(String str,int left,int right){
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
