class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length())
            if(haystack.equals(needle))
                return 0;
        int index = -1;
        char c = needle.charAt(0);
        for(int i=0;i<haystack.length();i++){
            if((haystack.charAt(i)==c) && (i+needle.length()-1<haystack.length()) && (haystack.substring(i,i+needle.length()).equals(needle))){
                index = i;
                break;
            }
        }
        return index;
    }
}