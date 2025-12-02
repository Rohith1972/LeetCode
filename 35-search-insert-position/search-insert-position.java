class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = -1;
        if(target < nums[0])
            return 0;
        if(target > nums[nums.length-1])
            return nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                res = i;
                break;
            }
            else if(i+1<nums.length && nums[i]<target && nums[i+1]>target ){
                res = i+1;
                break;
            }
        }
        return res;
    }
}