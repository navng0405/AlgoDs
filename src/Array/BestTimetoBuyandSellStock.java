package Array;

class BestTimetoBuyandSellStock {
    public static void main(String[] args) {

        // Prices array
        int[] prices = {7, 1, 5, 3, 6, 4};
        // Calculating the max profit
        int ans = maxProfit(prices, prices.length);
        // Print the answer
        System.out.println(ans);
    }
    private static int maxProfit(int[] prices, int n) {
        int maxSP[] = new int[n];
        int max = Integer.MIN_VALUE;
        //Fill up price cost array with most selling price
        for(int i=n-1;i>=0;i--){
            if(prices[i]>max){
                max=prices[i];
                maxSP[i] = Integer.MIN_VALUE;
            }else{
                maxSP[i] = max;
            }
        }
        int price = 0;
        for(int i=0;i<n;i++){
            if(maxSP[i] != Integer.MIN_VALUE){
                price = Math.max(price,maxSP[i]-prices[i]);
            }
        }
        return price;
    }
}
