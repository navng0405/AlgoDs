package Mart;

/**
 * Balanced ArrayEasy
 * Skills:
 * Problem Solving (Basic)
 * Tags:
 * Data Structures, Dynamic Programming, Algorithms, Problem Solving +1
 * Use
 * Given an array of numbers, find the index of the smallest array element (the pivot), for which the sums of all elements to the left and to the right are equal. The array may not be reordered.
 *
 * Example
 * arr=[1,2,3,4,6]
 *
 * the sum of the first three elements, 1+2+3=6. The value of the last element is 6.
 * Using zero based indexing, arr[3]=4 is the pivot between the two subarrays.
 * The index of the pivot is 3.
 *
 * Function Description
 * Complete the function balancedSum in the editor below.
 *
 * balancedSum has the following parameter(s):
 *     int arr[n]:  an array of integers
 * Returns:
 *     int: an integer representing the index of the pivot
 *
 * Constraints
 * 3 ≤ n ≤ 105
 * 1 ≤ arr[i] ≤ 2 × 104, where 0 ≤ i < n
 * It is guaranteed that a solution always exists.
 * Input Format for Custom Testing
 * Sample Case 0
 * Sample Input 0
 * STDIN 	Function Parameters
 * ----- 	-------------------
 * 4      →  arr[] size n = 4
 * 1      →  arr = [1, 2, 3, 3]
 * 2
 * 3
 * 3
 *
 * Sample Output 0
 * 2
 *
 * Explanation 0
 * The sum of the first two elements, 1+2=3. The value of the last element is 3.
 * Using zero based indexing, arr[2]=3 is the pivot between the two subarrays.
 * The index of the pivot is 2.
 * Sample Case 1
 * Sample Input 1
 * STDIN 	Function Parameters
 * ----- 	-------------------
 * 3      →  arr[] size n = 3
 * 1      →  arr = [1, 2, 1]
 * 2
 * 1
 *
 *
 *
 * Sample Output 1
 * 1
 *
 * Explanation 1
 * The first and last elements are equal to 1.
 * Using zero based indexing, arr[1]=2 is the pivot between the two subarrays.
 * The index of the pivot is 1.
 *
 * Interviewer Guidelines
 * Interviewer Guidelines are private and won't be visible to candidates
 * Private
 * Interviewer guidelines are a set of hints and follow up questions to help you guide and evaluate the candidate.
 * Hint 1
 * For each index, find the sum to its left and right and check if they are equal. This index which satisfies the condition will be distinct.
 * Hint 2
 * Use prefix sum to calculate the sum till each index.
 * Solution
 * Concepts Covered: Basic Programming Skills, Loops, Arrays, Problem Solving. The problem tests the candidate's ability to use loops and array handling. It requires the candidate to come up with an algorithm to find the pivot point where the sum of prefix and suffix till that point is equal in a constrained time and space complexity.
 *
 *
 *
 * Optimal Solution: Let's take the prefix sum of the array denoted by pf[ ]. pf[i] denotes the sum of all array elements in the range [0, i].
 * So for each index i, we just need to check if pf[i - 1] = tot_sum - pf[i], where tot_sum is the sum of all array elements in the array.
 * Time Complexity: O(N)
 * def balancedSum(arr):
 *     # Write your code here
 *     sum = 0
 *     pf = [0] * len(arr)
 *     # store the prefix sums for each index
 *     # while calculating the overall array sum
 *     for i in range(len(arr)):
 *         sum += arr[i]
 *         pf[i] = sum
 *     # pf[i-1] is the prefix sum up to the current index
 *     # sum - pf[i] is the sum of elements from the current index to the end
 *     for i in range(1, len(arr)):
 *         if(pf[i - 1] == sum - pf[i]):
 *             return i
 *
 * Brute Force Approach: For each index i, find the sum of all the element values in the range [1, i - 1] and the sum in the range [i + 1, n]. If both these sums are equal that point is the pivot.
 * Time Complexity: O(N^2)
 *
 * Error Handling:
 * 1. It's important to omit the index which is considered as the current pivot in the left sum and right sum. If you consider prefix sum, then pf[i - 1] should only be the left sum and not pf[i]. Similarly, (tot_sum - pf[i]) should be the right sum and not (tot_sum - pf[i - 1]).
 *
 * Complexity Analysis
 * Follow up Question
 * How about if you are asked to optimize the space complexity?
 *
 * Let pf_sum be the sum of all elements from [0, i] till any index i. Then the condition for any index i to be a pivot :
 * sum - pf_sum = pf_sum - arr[i]. (sum = total sum of arr)
 *
 * Psuedo Code -
 * def balancedSum(arr):
 *     # Write your code here
 *     sum = 0
 *     for i in range(len(arr)):
 *         sum += arr[i]
 *     pf_sum = 0
 *     for i in range(0, len(arr)):
 *         pf_sum += arr[i]
 *         if(sum - pf_sum == pf_sum - arr[i]):
 *             return i
 *
 *
 *
 * Follow up Question
 * Let's suppose we can modify the array to check if each index i is a pivot or not.
 *
 * The array can be modified as:
 * For an index i to be a pivot:
 * Increase the value of any element to the right and decrease the value of any element to the right of index i, or
 * Decrease the value of any element to the right and increase the value of any element to the right of index i.
 *
 * This can be solved by just checking if (tot_sum - arr[i]) is divisible by 2.
 * Psuedo Code -
 * def balancedSum(arr):
 *     # Write your code here
 *     tot_sum = 0
 *     for i in range(len(arr)):
 *         tot_sum += arr[i]
 *     for i in range(1, len(arr) - 1):
 *         if((tot_sum - arr[i]) % 2 == 0):
 *             return i
 *
 *
 *
 */
public class BalancedArray {
    public static void main(String[] args) {
        int[] giveArray = {1, 2, 3, 3};
        System.out.println("Get Pivot Element index:"+ balancedSum(giveArray));
    }

    private static int getPivotElementIndex(int[] giveArray) {
        int[] leftSum = new int[giveArray.length];
        int[] rightSum = new int[giveArray.length];
        leftSum[0] = 0;
        rightSum[giveArray.length-1] = 0;
        for(int i =1;i<giveArray.length;i++){
            leftSum[i] = leftSum[i-1]+giveArray[i-1];
        }
        for(int i=giveArray.length-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+giveArray[i+1];
        }

        for(int i=0;i<giveArray.length;i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }

    private static int balancedSum(int[] giveArray){
        int totalSum = 0;
        for(int i:giveArray){
            totalSum +=i;
        }

        int leftSum=0;

        for(int i=0;i<giveArray.length;i++){
            totalSum = totalSum-giveArray[i];
            if(leftSum == totalSum){
                return i;
            }
            leftSum = leftSum+giveArray[i];
        }
        return -1;
    }

}
