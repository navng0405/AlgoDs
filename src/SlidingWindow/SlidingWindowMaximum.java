package SlidingWindow;

import java.util.*;

/**
 * Difficulty : Hard
 * Deque<Integer> deque = new Deque<>
 *
 */

class SlidingWindowMaximum {
    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        // Replace this placeholder return statement with your cod
        int start=0;
        int[] result = new int[nums.length-w+1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(i>=w-1){
                result[j++]=getMax(start,i,nums);
                start=start+1;
            }
        }

        return result;
    }

    public static int[] findMaxSlidingWindowDeque(int[] nums, int w) {
        if (nums == null || nums.length == 0 || w <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - w + 1];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - w + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offerLast(i);

            // If the window has hit size w, add the maximum to the result array
            if (i >= w - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    private static int getMax(int start,int end,int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(nums[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
        System.out.println(findMaxSlidingWindowDeque(nums,3));
    }
}
