class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] map = {-1,-1,-1};
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a'] = i;
            count = count +(1+Math.min(map[0],Math.min(map[1],map[2])));
        }
        return count;
    }
}