class Solution {
    public boolean isPalindrome(String s1) {
        String s = s1.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();
        int low=0,high=s.length()-1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}