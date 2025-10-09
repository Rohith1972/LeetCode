class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        int n = nums.length;
        int sum = (n*(n+1))/2;
        if(count == sum)
            return 0;
        return sum-count;
    }
}