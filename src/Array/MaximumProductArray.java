package Array;

public class MaximumProductArray {
    public static long maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long maxProduct = nums[0];
        long minProduct = nums[0];
        long result = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            long tempMax = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]), nums[i]);
            minProduct = Math.min(Math.min(tempMax * nums[i], minProduct * nums[i]), nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,12,15,23,33,-35,30,-40,-30,-30,-30,26,28};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums));
    }
}
