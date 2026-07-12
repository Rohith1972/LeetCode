class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int top = matrix[i][j]+dp[i-1][j];
                int ld = matrix[i][j];
                if(j-1>=0)ld+=dp[i-1][j-1];
                else ld+=(int)1e9;
                int rd = matrix[i][j];
                if(j+1<m)rd+=dp[i-1][j+1];
                else rd+=(int)1e9;
                dp[i][j] = Math.min(top,Math.min(ld,rd));
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini = Math.min(mini,dp[m-1][j]);
        }
        return mini;
    }
}