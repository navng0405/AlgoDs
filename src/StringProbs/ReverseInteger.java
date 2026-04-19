package StringProbs;

public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10; // Extract the last digit
            int newResult = result * 10 + tail; // Append the digit to the reversed number

            // Check for overflow by reversing the operation and comparing
            if ((newResult - tail) / 10 != result) {
                return 0; // Overflow occurred
            }

            result = newResult;
            x = x / 10; // Move to the next digit
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); // Output: 321
        System.out.println(reverse(-123)); // Output: -321
        System.out.println(reverse(120)); // Output: 21
    }
}

