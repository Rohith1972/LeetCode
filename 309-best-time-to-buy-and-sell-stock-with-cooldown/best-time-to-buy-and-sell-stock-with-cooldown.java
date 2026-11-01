class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[2];
        int[] next2 = new int[2];
        for(int ind=prices.length-1;ind>=0;ind--){
            int[] cur = new int[2];
            cur[1] = Math.max(
                -prices[ind] + next[0],
                next[1]
            );
            cur[0] = Math.max(
                prices[ind] + next2[1],
                next[0]
            );
            next2 = next;
            next = cur;
        }
        return next[1];
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