class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int ind=prices.length-1;ind>=0;ind--){
            dp[ind][1] = Math.max(
                -prices[ind] + dp[ind+1][0],
                dp[ind+1][1]
            );
            dp[ind][0] = Math.max(
                prices[ind] + dp[ind+2][1],
                dp[ind+1][0]
            );
        }
        return dp[0][1];
    }
    int fun(int ind,int buy,int[] prices,int[][] dp){
        if(ind >= prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        if(buy == 1){
            return dp[ind][buy] = Math.max(
                -prices[ind] + fun(ind+1,0,prices,dp),
                fun(ind+1,1,prices,dp)
            );
        }
        return dp[ind][buy] = Math.max(
            prices[ind] + fun(ind+2,1,prices,dp),
            fun(ind+1,0,prices,dp)
        );
    }
}