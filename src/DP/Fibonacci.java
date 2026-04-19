package DP;

/**
 * fib(0)=0
 * fib(1)=1
 * fib(n) = fib(n-1)+fib(n-2)
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n=3000;
        System.out.println(fib(n));
    }

    private static long fib(int n) {
        //Base Case
        if(n<=1){
            return n;
        }

        //Array to store fibonacci number
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}
