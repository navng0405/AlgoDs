package Maths;

public class FibonacciChecker {

    // Method to check if x is a perfect square
    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    // Method to check if n is a Fibonacci number
    public static boolean isFibonacci(int n) {
        // Check if one of these expressions is a perfect square
        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
    }

    public static void main(String[] args) {
        int n = 5; // Example number to check
        if (isFibonacci(n)) {
            System.out.println(n + " is a Fibonacci number.");
        } else {
            System.out.println(n + " is not a Fibonacci number.");
        }
    }
}

