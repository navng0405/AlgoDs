package Maths;

/**
 * x power of n = x powerof n/2 * x powerof n/2 == if n is even
 * x * x powerof n/2* * x power of n/2 == if n is odd
 */
public class PowerExpo {
    public static void main(String[] args) {
        System.out.println(myPower(2,-3));
    }

    private static double myPower(double x, int n){
        if(x == 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }
        long N = n;
        if(n<0){
            x = 1/x;
            N = -N;
        }

        return fastPower(x,N);
    }

    private static double fastPower(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPower(x,n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }
}
