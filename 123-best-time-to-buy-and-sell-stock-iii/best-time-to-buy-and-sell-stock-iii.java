class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        
        dp[prices.length][0][2] = 0;
        dp[prices.length][1][2] = 0;

        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap>=0;cap--){
                    if(buy == 1){
                        dp[ind][buy][cap] = Math.max(
                            -prices[ind] + dp[ind+1][0][cap],
                            dp[ind+1][1][cap]
                        );
                    }else{
                        dp[ind][buy][cap] = Math.max(
                            prices[ind] + dp[ind+1][1][cap+1],
                            dp[ind+1][0][cap]
                        );
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}