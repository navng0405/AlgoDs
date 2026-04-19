package Array;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {2,4,3,1};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    private static int[] nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i]){
            i--;
        }

        if(i>=0){
            int j=nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }

            swap(nums,i,j);
        }

        reverse(nums,i+1);

        return nums;
    }


    // Utility method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Utility method to reverse a subarray
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
