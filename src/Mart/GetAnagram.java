package Mart;

public class GetAnagram {
    public static int getAnagram(String s) {
        // Split the string into two halves
        int n = s.length();
        String firstHalf = s.substring(0, n / 2);
        String secondHalf = s.substring(n / 2);

        // Create frequency arrays for digits 0-9
        int[] firstHalfFreq = new int[10];
        int[] secondHalfFreq = new int[10];

        // Calculate the frequency of each digit in both halves
        for (int i = 0; i < firstHalf.length(); i++) {
            firstHalfFreq[firstHalf.charAt(i) - '0']++;
        }

        for (int i = 0; i < secondHalf.length(); i++) {
            secondHalfFreq[secondHalf.charAt(i) - '0']++;
        }

        // Calculate the number of operations needed
        int operations = 0;
        for (int i = 0; i < 10; i++) {
            operations += Math.abs(firstHalfFreq[i] - secondHalfFreq[i]);
        }

        // Since each mismatch requires one operation to fix, and
        // we've counted each mismatch twice (once for each half),
        // we divide by 2 to get the actual number of operations needed.
        return operations / 2;
    }

    public static void main(String[] args) {
        String s = "123122";
        System.out.println("Minimum operations: " + getAnagram(s));
    }
}
