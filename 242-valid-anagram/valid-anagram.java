class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ch = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int x = c - 'a';
            ch[x]++;
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int x = c - 'a';
            ch[x]--;
        }
        for(int i=0;i<26;i++){
            if(ch[i]!=0)
                return false;
        }
        return true;
    }
}