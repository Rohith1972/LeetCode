class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return solve(s1.length()-1,s2.length()-1,s1,s2,dp);
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