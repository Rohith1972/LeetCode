class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0,j=nums.length-1;
        int k = nums.length-1;
        int[] res = new int[k+1];
        while(i<=j){
            int x = nums[i]*nums[i];
            int y = nums[j]*nums[j];
            if(x>y){
                res[k--]=x;
                i++;
            }else{
                res[k--]=y;
                j--; 
            }
        }
        return res;
    }
}