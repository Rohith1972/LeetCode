class Solution {
    public String mergeAlternately(String S1, String S2) {
        char[] ch1 = S1.toCharArray();
        char[] ch2 = S2.toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        int i=0,j=0;
        StringBuilder res = new StringBuilder();
        while(i<n||j<m){
            if(i<n){
                res.append(ch1[i]);
                i++;
            }
            if(j<m){
                res.append(ch2[j]);
                j++;
            }
        }
        return res.toString();
    }
}