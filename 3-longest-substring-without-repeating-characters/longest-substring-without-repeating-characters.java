class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxSize = 0;
        while(j<s.length()){
            if(hm.containsKey(s.charAt(j))){
                i = Math.max(i,hm.get(s.charAt(j))+1);
            }
            maxSize = Math.max(maxSize,j-i+1);
            hm.put(s.charAt(j),j);
            j++;
        }
        return maxSize;
    }
}