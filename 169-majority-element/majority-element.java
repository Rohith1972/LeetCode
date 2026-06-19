class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                curr = nums[i];
                count++;
            }
            else if(nums[i] == curr)
                count++;
            else
                count--;
        }
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == curr)
                cnt++;
        }
        if(cnt > nums.length/2)
            return curr;
        return -1;
    }
}