class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int x : nums)
            totSum += x;
        if ((target) > totSum)
            return 0;

        if ((totSum - target) % 2 != 0)
            return 0;
        int sum = (totSum - target) / 2;
        int[][] dp = new int[nums.length][sum+1];
        for(int[] i : dp)
            Arrays.fill(i,-1);
        return solve(nums.length-1,sum,nums,dp);
    }
    static int solve(int ind,int target,int[] nums,int[][] dp){
        if(ind == 0){
            if(target == 0 && nums[0] == 0)
                return 2;
            if(target == 0 || nums[0] == target)
                return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int  notTake = solve(ind-1,target,nums,dp);
        int  take = 0;
        if(nums[ind] <= target)
            take = solve(ind-1,target-nums[ind],nums,dp);
        return dp[ind][target] = (take+notTake);
    }
}