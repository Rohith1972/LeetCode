class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] i :dp){
            Arrays.fill(i,-1);
        }
        return f(n,m,s1,s2,dp);
    }
    int f(int i,int j,String s1,String s2,int dp[][]){
        
        if(i == 0) return j;
        if(j == 0) return i;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = f(i-1,j-1,s1,s2,dp);
        }
        int insert = 1+f(i-1,j,s1,s2,dp);
        int delete = 1+f(i,j-1,s1,s2,dp);
        int replace = 1+f(i-1,j-1,s1,s2,dp);
        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
}