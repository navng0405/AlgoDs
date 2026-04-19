package Array;

import java.util.Arrays;

public class CountTriplets {
    public static int countTriplets(int[] arr, int value) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < value) {
                    count += right - left; // Since arr[right] is the largest, all elements between left and right will satisfy the condition
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 3};
        int value = 2;
        System.out.println("Count of triplets: " + countTriplets(arr, value));
    }
}
