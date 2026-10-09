class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return lcs(s1,s2,s1.length(),s2.length(),dp);
    }
    public int lcs(String s,String t,int i,int j,int[][] dp){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = 1+lcs(s,t,i-1,j-1,dp);
        }

        return dp[i][j] = Math.max(
            lcs(s,t,i-1,j,dp),
            lcs(s,t,i,j-1,dp)
        );
    }
}