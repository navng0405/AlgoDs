package Array;

//Increasing Triplet Subsequence LeetCode Solution – Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
//
//Example :
//Example 1:
//Input: nums = [2,1,5,0,4,6]
//Output: true
//Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
//link : https://tutorialcup.com/leetcode-solutions/increasing-triplet-subsequence-leetcode-solution.htm

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] givenArray = {1,2,3,4,5};
        System.out.println(getIncreasingTriplet(givenArray));
    }

    private static boolean getIncreasingTriplet(int[] givenArray) {
        if(givenArray == null || givenArray.length==0){
            return false;
        }
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for(int i= 0;i<givenArray.length;i++){
            int right = givenArray[i];
            if(right<left){
                left = right;
            }else if(right<middle && right>left){
                middle=right;
            }else if(right>middle && right>left){
                return true;
            }
        }
    return false;
    }
}
