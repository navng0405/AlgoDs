package Matrices;

public class KthSmallest {

    public static void main(String[] args) {
        int[][] givenMatrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k=8;
        System.out.println(kthSmallest(givenMatrix,k));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; // The smallest element in the matrix
        int high = matrix[n - 1][n - 1]; // The largest element in the matrix

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                // If the count of numbers less than or equal to mid is less than k,
                // it means the kth smallest number is larger than mid.
                low = mid + 1;
            } else {
                // Otherwise, the kth smallest number is less than or equal to mid.
                high = mid;
            }
        }

        return low;
    }

    private static int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n - 1; // Start from the bottom row
        int j = 0; // Start from the first column
        int count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                // If the current number is less than or equal to the target,
                // all numbers in the current row above it are also less than or equal to the target.
                count += i + 1;
                j++; // Move to the next column
            } else {
                // If the current number is larger than the target, move up a row.
                i--;
            }
        }

        return count;
    }

}
