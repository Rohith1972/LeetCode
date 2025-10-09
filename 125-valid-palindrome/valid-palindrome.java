class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c))
                res.append(c);
        }
        String s1 = res.toString().toLowerCase();
        String s2 = res.reverse().toString().toLowerCase();
        return s1.equals(s2);
    }
}