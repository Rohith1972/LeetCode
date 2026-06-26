class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0,maxFreq=0,maxLength=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(right<s.length()){
            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,hm.get(s.charAt(right)));
            while((right-left+1)-maxFreq>k){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            maxLength = Math.max(right-left+1,maxLength);
            right++;
        }
        return maxLength;
    }
}