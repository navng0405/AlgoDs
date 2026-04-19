package Array;

public class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMax = 0;
        int currMin = 0;

        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
            totalSum += num;
        }

        // If all numbers are negative, maxSum is the maximum
        if (totalSum == minSum) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] givenArray = {5,-3,5};
        System.out.println(maxSubarraySumCircular(givenArray));
    }
}
