class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        dp[n][1] = dp[n][2] = 0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=2;buy>=1;buy--){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind]+dp[ind+1][2],
                                dp[ind+1][1]);
                }else{
                    profit = Math.max(prices[ind]+dp[ind+1][1],
                                dp[ind+1][2]);
                }
                dp[ind][buy] = profit;
            }
        } 
        return dp[0][1];
    }
    int f(int ind ,int buy,int[] prices,int[][] dp){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        } 
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind]+f(ind+1,1,prices,dp),
                        0+f(ind+1,2,prices,dp));
        }else{
            profit = Math.max(prices[ind]+f(ind+1,2,prices,dp),
                        f(ind+1,1,prices,dp));
        }
        return dp[ind][buy] = profit;
    }
}