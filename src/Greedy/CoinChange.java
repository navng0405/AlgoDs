package Greedy;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 47;
        System.out.println("No of count :" + coinCounts(coins,amount));
    }

    private static int coinCounts(int[] coins, int amount) {
        int count=0;
        Arrays.sort(coins);
        for(int i=coins.length-1;i>=0;i--){
            while(amount>=coins[i]){
                amount = amount-coins[i];
                System.out.print(coins[i] + "+");
                count++;
            }
        }

        return count;
    }
}
