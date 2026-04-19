package BackTracking;
/**                         []
                        /    |   \
                       /     |     \
                      1       2       3
                     / \     / \     / \
                    2   3   1   3   1   2
                   |   |   |   |   |   |
                   3   2   3   1   2   1

 * o/p : [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
 */

import java.util.*;
public class Permutations {
    public static void main(String[] args){
        int[] nums = {1, 2, 3,4};
        List<List<Integer>> answer = getPermutations(nums);
        System.out.println(answer);
    }
    private static List<List<Integer>> getPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrackPermutation(nums,result,tempList);

        return  result;
    }

    private static void backTrackPermutation(int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])){
                    continue;
                }
                tempList.add(nums[i]);
                backTrackPermutation(nums,result,tempList);
                tempList.removeLast();
            }
        }
    }


}

