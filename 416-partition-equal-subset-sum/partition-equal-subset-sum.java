class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            totSum += nums[i];
        }
        if(totSum%2!=0)
            return false;
        boolean[][] dp = new boolean[n][(totSum/2)+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= totSum/2)
            dp[0][nums[0]] = true;
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=totSum/2;target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(nums[ind] <= target)
                    take = dp[ind-1][target-nums[ind]];
                dp[ind][target] = (take || notTake);
            }
        }
        return dp[n-1][totSum/2];
    }
    boolean solve(int ind,int target,int[] nums,int[][] dp){
        if(target == 0)
            return false;
        if(ind == 0)
            return nums[0] == target;
        if(dp[ind][target]!=-1)
            return dp[ind][target]==1;
        boolean notTake = solve(ind-1,target,nums,dp);
        boolean take = false;
        if(nums[ind] <= target)
            take = solve(ind-1,target-nums[ind],nums,dp);
        dp[ind][target] = (take || notTake)?1:0;
        return take || notTake;
    }
}