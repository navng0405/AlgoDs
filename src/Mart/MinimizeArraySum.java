package Mart;

import java.util.PriorityQueue;

/**
 * Given an array of Integers,perform some number of operations.Each operations consists of removing an element from the array
 * dividing it by 2 and inserting the ceiling of that result back into the array. Minimize the sum of the elements in the final array
 *
 * nums[10,20,7]
 * k=4
 *
 * final : 5+5+4=14
 */
public class MinimizeArraySum {
    public static void main(String[] args) {
        int[] nums = {10,20,7};
        System.out.println(getMinimizeArray(nums,4));

    }

    private static int getMinimizeArray(int[] nums,int k) {
        //Use a max-heap to store the nums in reverse order
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i : nums){
            queue.add(i);
        }
        //Perform k operations
        for(int i=0;i<k;i++){
            int maxVal = queue.poll();
            //Divide the max val by 2 and the ceiling
            int newVal = (int)Math.ceil(maxVal/2.0);
            queue.add(newVal);
        }
        int sum=0;
        while(!queue.isEmpty()){
            sum +=  queue.poll();
        }
        return sum;
    }
}
