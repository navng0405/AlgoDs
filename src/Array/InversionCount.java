package Array;

import java.util.Arrays;

public class InversionCount {

    /**
     * Create 2 arrays from original arrays > l to mid+1, mid+1 to r using Arrays.copyOfRange
     * Compare and merge 2 arrays into original
     * when right element is smaller than lefty, then swap and count m+1   -- l-i
     * @param arr
     * @param l
     * @param m
     * @param r
     * @return
     */

    private static int mergeAndCount(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }

    /**
     * Calculate mid and divide the array and merge it
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    public static int inversionCount(int[] arr, int n) {
        return mergeSortAndCount(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] givenArray ={4,3,2,9,1};
        System.out.println("Inversion Count :" + inversionCount(givenArray,givenArray.length));
    }
}
