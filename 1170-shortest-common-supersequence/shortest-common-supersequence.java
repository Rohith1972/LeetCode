class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int ind1=1;ind1<=s1.length();ind1++){
            for(int ind2=1;ind2<=s2.length();ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        int i = s1.length();
        int j = s2.length();
        StringBuilder ans = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(String.valueOf(s1.charAt(i-1)));
                i--;
            }else{
                ans.append(String.valueOf(s2.charAt(j-1)));
                j--;
            }
        }
        while(i > 0){
            ans.append(String.valueOf(s1.charAt(i-1)));
            i--;
        }
        while(j > 0){
            ans.append(String.valueOf(s2.charAt(j-1)));
            j--;
        }
        return ans.reverse().toString();
    }
}