package StringProbs;

public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 12121;
        System.out.println("Is " + number + " a palindrome? " + isPalindrome(number));
    }

    private static boolean isPalindrome(int number) {
        if(number<0 || number%10 == 0 || number == 0){
            return false;
        }

        int reverHalf = 0;
        while(number > reverHalf){
            reverHalf = reverHalf*10+number%10;
            number = number/10;
        }

        return reverHalf == number || reverHalf/10 == number;
    }
}
