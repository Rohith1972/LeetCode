class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) dp[0][t]=1;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int t=0;t<=amount;t++){
                int notTake = dp[ind-1][t];
                int take = 0;
                if(coins[ind]<=t){
                    take = dp[ind][t-coins[ind]];
                }
                dp[ind][t] = take+notTake;
            }
        }
        return dp[coins.length-1][amount];
    }
    static int solve(int ind,int target,int[] coins,int[][] dp){
        if(ind == 0){
            if(target%coins[ind]==0) return 1;
            else return 0; 
        }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int notTake = solve(ind-1,target,coins,dp);
        int take = 0;
        if(coins[ind]<=target){
            take = solve(ind,target-coins[ind],coins,dp);
        }
        return dp[ind][target] = take+notTake;
    }
}