package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array consisting of number 0’s and 1’s only.
 * We have to find the length of the longest contiguous sub-array consisting o’s and 1’s equally.
 *
 * Iterate given array and if 1 -> sum = sum+1
 * 0-> sum=sum-1
 *
 * everything map sum to map > key-sum vale,v = current index
 *
 * if key already exist in map -> current index - map entry value ---> longest subarray len
 *
 *
 * O(n) --- TC ---> Iterating the whole array
 * O(n)  ---- SC --- Using auxiliary map
 */
public class ContiguousArray {
    public static void main(String[] args) {
        int[] givenArray = {0,1,1,1,0,0,0};
        System.out.println(getLongestSubArrayLen(givenArray));
    }

    private static int getLongestSubArrayLen(int[] givenArray) {
        Map<Integer,Integer> dictionary = new HashMap<>();
        int longSubArray = 0;
        int sum = 0;
        for(int i = 0;i<givenArray.length;i++){
            if(givenArray[i] == 0){
                sum = sum-1;
            }else{
                sum = sum+1;
            }
            if(dictionary.containsKey(sum)){
                longSubArray = Math.max(longSubArray,i-dictionary.get(sum));
            }else{
                dictionary.put(sum,i);
            }
        }
        return longSubArray;
    }
}
