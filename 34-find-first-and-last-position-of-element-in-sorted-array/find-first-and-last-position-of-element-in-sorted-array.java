class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums,target);
        int last = lastPos(nums,target);
        return new int[]{first,last};
    }
    int firstPos(int[] nums , int target){
        int low = 0;
        int high = nums.length-1;
        int pos = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target <= nums[mid]){
                if(target == nums[mid]){
                    pos = mid;
                }
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return pos;
    }
    int lastPos(int[] nums , int target){
        int low = 0;
        int high = nums.length-1;
        int pos = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target >= nums[mid]){
                if(target == nums[mid]){
                    pos = mid;
                }
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return pos;
    }
}