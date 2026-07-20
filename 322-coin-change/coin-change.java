class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        int target = amount;
        for(int t=0;t<=target;t++){
            if(t%coins[0]==0) prev[t] = t/coins[0];
            else prev[t] = (int)1e9;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int t=0;t<=target;t++){
                int notTake = prev[t];
                int take = (int)1e9;
                if(coins[ind]<=t){
                    take = 1 + curr[t-coins[ind]];
                }
                curr[t] = Math.min(take,notTake);
            }
            prev = curr;
        }
        int ans = prev[target];
        if(ans == 1e9) return -1;
        return ans;
    }
    static int solve(int ind,int target,int[] coins,int[][] dp){
        if(ind == 0){
            if(target%coins[ind]==0) return target/coins[ind];
            else return (int)1e9; 
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int notTake = solve(ind-1,target,coins,dp);
        int take = (int)1e9;
        if(coins[ind]<=target){
            take = 1 + solve(ind,target-coins[ind],coins,dp);
        }
        return dp[ind][target] = Math.min(take,notTake);
    }
}