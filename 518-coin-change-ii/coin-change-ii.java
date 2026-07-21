class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) prev[t]=1;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int t=0;t<=amount;t++){
                int notTake = prev[t];
                int take = 0;
                if(coins[ind]<=t){
                    take = curr[t-coins[ind]];
                }
                curr[t] = take+notTake;
            }
            prev = curr;
        }
        return prev[amount];
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