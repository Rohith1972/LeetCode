class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int res = -1;
        if(target < nums[0])
            return 0;
        if(target > nums[n-1])
            return n;
        for(int i=0;i<n;i++){
            if(nums[i] == target){
                res = i;
                break;
            }
            else if(i+1<n && nums[i]<target && nums[i+1]>target ){
                res = i+1;
                break;
            }
        }
        return res;
    }
}