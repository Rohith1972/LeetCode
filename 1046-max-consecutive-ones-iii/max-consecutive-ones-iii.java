class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0;
        int zeros=0,maxLength=0;
        while(right<nums.length){
            if(nums[right] == 0)
                zeros++;
            if(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLength = Math.max(right-left+1,maxLength);
            right++;
        }
        return maxLength;
    }
}