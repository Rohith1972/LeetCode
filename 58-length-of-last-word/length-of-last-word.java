class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.split("\\s+");
        String res1 = res[res.length-1];
        return res1.length();
    }
}