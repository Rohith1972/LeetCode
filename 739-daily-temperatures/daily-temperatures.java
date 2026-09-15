class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nge = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = 0;
            }else{
                nge[i] = st.peek() - i;
            }
            st.push(i);
        }
        return nge;
    }
}