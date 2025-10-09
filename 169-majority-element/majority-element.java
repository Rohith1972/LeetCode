class Solution {
    public int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                elem = nums[i];
                count++;
            }else if(nums[i]==elem)
                count++;
            else
                count--;
        }
        count = 0;
        for (int num : nums) {
            if (num == elem) 
                count++;
        }
        if (count > nums.length / 2) {
            return elem;
        }
        return -1;
    }
}