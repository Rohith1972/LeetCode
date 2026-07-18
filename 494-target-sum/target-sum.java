class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length-1,0,target,nums);
    }
    static int solve(int ind,int ans,int target,int[] nums){
        if(ind < 0){
            return (ans == target)?1:0;
        }
        int add = solve(ind-1,ans+nums[ind],target,nums);
        int sub = solve(ind-1,ans-nums[ind],target,nums);
        return add+sub;
    }
}