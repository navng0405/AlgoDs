package Mart;

import java.util.HashSet;
import java.util.Set;

/**
 * Dominating XOREasy
 * Skills:
 * Problem Solving (Basic)
 * Tags:
 * Bitwise Operations, Hash Map, Interviewer Guidelines
 * For an array arr of n positive integers, count the unordered pairs (i, j) (0 ≤ i < j < n) where arr[i] XOR arr[j] > arr[i] AND arr[j]. XOR denotes the bitwise XOR operation and AND denotes the bitwise AND operation.
 *
 *
 *
 * Example
 *
 * Given n = 4, arr  = [4, 3, 5, 2]. All unordered pairs (i, j) are-
 *
 * Indices XOR  AND XOR > AND
 * (0,1)    7    0    True
 * (0,2)    1    4    False
 * (0,3)    6    0    True
 * (1,2)    6    1    True
 * (1,3)    1    2    False
 * (2,3)    7    0    True
 *
 *
 * For the first line:
 *
 * arr[0] = 4, arr[1] = 3
 * 4 XOR 3 = 7
 * 4 AND 3 = 0
 * 7 > 3
 *
 *
 * There are 4 good pairs where XOR > AND shows True. Return 4.
 *
 *
 *
 * Function Description
 *
 * Complete the function dominatingXorPairs in the editor below.
 *
 *
 *
 * dominatingXorPairs has the following parameter:
 *
 *     int arr[n]:  an array of integers
 *
 *
 *
 * Returns
 *
 *     long int: the number of good pairs
 *
 *
 *
 * Constraints
 *
 * 1 ≤ n ≤ 105
 * 1 ≤ arr[i] < 230
 */
public class DominatingXorPairs {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2};
        System.out.println("Number of good pairs: " + dominatingXorPairs(arr));
        System.out.println("Number of good pairs: " + dominatingXorPairsOP(arr));
    }

    private static Integer dominatingXorPairs(int[] arr) {
        int goodPairs = 0;
        if(arr.length == 0){
            return goodPairs;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(((arr[i] != arr[j]) && (arr[i]^arr[j]) > (arr[i]&arr[j]))){
                    goodPairs = goodPairs+1;
                }
            }
        }

        return goodPairs;
    }

    public static long dominatingXorPairsOP(int[] arr) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : arr) {
            distinctElements.add(num);
        }

        long d = distinctElements.size();
        // If d is 1, it means all elements are the same, hence no valid pairs
        if (d == 1) {
            return 0;
        }
        // Calculate number of pairs
        return (d * (d - 1)) / 2;
    }

}
