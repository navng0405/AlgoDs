package problems.DP;

/**
 *                                                     1 2 3 4
 *                                          sum :4,currin:0,se:1                        sum:5,curren:1,se:
 *                            sum:2 currr:1,sel:1,2   sum:4,curr:2,sel:1    sum:3,cur:2,se:2    sum:5,cur:3,se:
 *                                             sum:1,cur:3,sel:1,3 sum:0,cur:
 */
public class PartitionSet {

    public boolean canPartition(int[] num){
        int sum = 0;
        for(int i : num){
            sum += i;
        }
        if(sum%2 != 0){
            return false;
        }
        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
        return canPartitionDP(dp,num,sum/2,0);
    }
    public boolean canPartitionDP(Boolean[][] dp, int[] num, int sum, int currentIndex){
        if(sum==0){
            return true;
        }
        if(num.length<=currentIndex){
            return false;
        }
        if(dp[currentIndex][sum] == null){
            if(num[currentIndex]<=sum){
                if(canPartitionDP(dp,num,sum-num[currentIndex],currentIndex+1)){
                    dp[currentIndex][sum] = true;
                    return dp[currentIndex][sum];
                }
            }
            dp[currentIndex][sum]=canPartitionDP(dp,num,sum,currentIndex+1);
        }
        return dp[currentIndex][sum];
    }
    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
