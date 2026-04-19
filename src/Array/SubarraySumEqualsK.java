package Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // For subarray that sums to k from the start

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,0,5,10,3,2,-15,4};
        subarraySum(arr,5);
    }
}

