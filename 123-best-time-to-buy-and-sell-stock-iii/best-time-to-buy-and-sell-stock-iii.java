class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i[][] : dp){
            for(int[] j : i){
                Arrays.fill(j,-1);
            }
        }
        return fun(0,1,0,prices,dp);
    }
    int fun(int ind,int buy,int cap,int[] prices,int[][][] dp){
        if(ind == prices.length || cap==2){
            return 0;
        }
        if(dp[ind][buy][cap] != -1){
            return dp[ind][buy][cap];
        }
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(
                -prices[ind] + fun(ind+1,0,cap,prices,dp),
                fun(ind+1,1,cap,prices,dp)
            );
        }
        return dp[ind][buy][cap] = Math.max(
            prices[ind] + fun(ind+1,1,cap+1,prices,dp),
            fun(ind+1,0,cap,prices,dp)
        );

    }
}