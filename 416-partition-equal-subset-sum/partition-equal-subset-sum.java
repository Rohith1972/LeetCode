class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            totSum += nums[i];
        }
        if(totSum%2!=0)
            return false;
        boolean[] prev = new boolean[(totSum/2)+1];
        for(int i=0;i<n;i++){
            prev[0] = true;
        }
        if(nums[0] <= totSum/2)
            prev[nums[0]] = true;
        for(int ind=1;ind<n;ind++){
            boolean curr[] = new boolean[(totSum/2)+1];
            for(int target=1;target<=totSum/2;target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(nums[ind] <= target)
                    take = prev[target-nums[ind]];
                curr[target] = (take || notTake);
            }
            prev = curr;
        }
        return prev[totSum/2];
    }
}