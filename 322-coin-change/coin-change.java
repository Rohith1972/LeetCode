class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        int ans = solve(coins.length-1,amount,coins,dp);
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