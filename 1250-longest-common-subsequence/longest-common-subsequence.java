class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[] prev = new int[s2.length()+1];
        for(int i=0;i<s2.length();i++){
            prev[i] = 0;
        }
        for(int ind1=1;ind1<=s1.length();ind1++){
            int[] curr = new int[s2.length()+1];
            for(int ind2=1;ind2<=s2.length();ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                    curr[ind2] = 1 + prev[ind2-1];
                else curr[ind2] = Math.max(prev[ind2],curr[ind2-1]);
            }
            prev = curr;
        }
        return prev[s2.length()];
    }
    int solve(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)
            return 0;
        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2))
            return 1 + solve(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2] = Math.max(solve(ind1-1,ind2,s1,s2,dp),solve(ind1,ind2-1,s1,s2,dp));
    }
}