package Revist;

/**
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 */
public class Maximumlength {
    public static void main(String[] args) {
        int[] num1= {1,2,3,2,1};
        int[] num2={3,2,1,4,7};

        System.out.println(findMaxLen(num1,num2));
    }

    private static int findMaxLen(int[] num1, int[] num2) {
        int maxLength = 0;
        int[][] dp = new int[num1.length+1][num2.length+1];
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num2.length;j++){
                if(num1[i] == num2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                    maxLength = Math.max(maxLength,dp[i+1][j+1]);
                }
            }
        }
        return maxLength;
    }
}
