package Maths;

public class Sqrt {
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid <= x / mid) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println("Square root: " + sqrt(num));
    }
}
