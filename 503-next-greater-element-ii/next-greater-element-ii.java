class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int index = i;
            if(i>=n){
                index = i % n;
            }
            while(!st.isEmpty() && nums[index] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nge[index] = -1;
            }else{
                nge[index] = st.peek();
            }
            st.push(nums[index]);
        }
        return nge;
    }
}