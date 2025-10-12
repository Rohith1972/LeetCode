class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(!st.empty() && st.peek()==c)
                st.pop();
            else
                st.push(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while(!st.empty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}