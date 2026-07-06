class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int pick = nums[i];
            if(i-1>0)
                pick+=prev2;
            int notPick = prev;
            int curri = Math.max(pick,notPick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}