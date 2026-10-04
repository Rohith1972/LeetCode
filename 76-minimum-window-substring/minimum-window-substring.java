class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int left = 0;
        int count = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        for(int right=0;right<s.length();right++){
            int ch = s.charAt(right);
            if(freq[ch]>0){
                count++;
            }
            freq[ch]--;
            while(count == t.length()){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    start = left;
                }
                int leftChar = s.charAt(left);
                freq[leftChar]++;
                if(freq[leftChar]>0){
                    count--;
                }
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE)?"":s.substring(start,start + minLength);
    }
}