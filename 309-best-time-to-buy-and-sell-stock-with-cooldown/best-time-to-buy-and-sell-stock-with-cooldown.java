class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return fun(0,1,prices,dp);
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