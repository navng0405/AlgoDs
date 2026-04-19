package Array;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = -1, end = -2; // Initialize end to -2 so that for already sorted array, end - start + 1 = 0
        int min = nums[n - 1], max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);

            if (nums[i] < max) end = i;
            if (nums[n - 1 - i] > min) start = n - 1 - i;
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray solution = new FindUnsortedSubarray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println("Length of Unsorted Subarray: " + solution.findUnsortedSubarray(nums));
    }
}

