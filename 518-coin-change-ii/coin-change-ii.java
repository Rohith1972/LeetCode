class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        int ans = solve(coins.length-1,amount,coins,dp);
        if(ans == 1e9)
            return 0;
        return ans;
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