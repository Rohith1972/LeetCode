class Solution {
    public int trap(int[] height) {
        
        int leftmax[] = new int[height.length];
        int rightmax[] = new int[height.length];

        // left max calculation

        //leftMax variable to keep track of max element until that element from left
        int leftMax = height[0];
        for(int i=1;i<height.length;i++){
            leftMax = Math.max(leftMax,height[i]);
            leftmax[i] = Math.max(leftMax,height[i]);
        }

        // right max calculation

        //rightMax variable to keep track of max element until that element from right
        int rightMax = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMax = Math.max(rightMax,height[i]);
            rightmax[i] = Math.max(rightMax,height[i]);
        }

        //Total trapped rain water calculation

        // sum variable to store total trapped rain water
        int sum = 0;
        for(int i=1;i<height.length-1;i++){
            sum += (Math.min(leftmax[i],rightmax[i])-height[i]);
        }

        return sum;

    }
}