class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                    }else{
                        profit = Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                    }
                    dp[ind][buy][cap] = profit;
                }
            }
        }
        
        return dp[0][1][2];
    }
    int fun(int ind, int buy ,int cap , int[] prices,int[][][] dp){
        if(ind==prices.length || cap == 0){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind]+fun(ind+1,0,cap,prices,dp),
                                fun(ind+1,1,cap,prices,dp));
        }else{
            profit = Math.max(prices[ind]+fun(ind+1,1,cap-1,prices,dp),
                            fun(ind+1,0,cap,prices,dp));
        }
        return dp[ind][buy][cap] = profit;
    }
}