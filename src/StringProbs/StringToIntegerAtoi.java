package StringProbs;

public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1, i = 0, n = str.length();
        long result = 0;

        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '-') ? -1 : 1;
        }

        while (i < n && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i++) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) result * sign;
    }

    public static void main(String[] args) {
        String input = "   -42    ";
        System.out.println(Integer.parseInt(input.trim()));
        System.out.println("Converted integer: " + myAtoi(input));
    }
}

