class Solution {
    public boolean isMatch(String string, String pattern) {
        int m = pattern.length();
        int n = string.length();
        Boolean[][] dp = new Boolean[m][n];
        return f(m-1,n-1,pattern,string,dp);
    }
    boolean f(int i,int j,String patt,String str,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int ii=0;ii<=i;ii++){
                if(!(patt.charAt(ii)=='*'))
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=null)
            return dp[i][j];
        if(patt.charAt(i) == str.charAt(j) || patt.charAt(i)=='?')
            return dp[i][j] = f(i-1,j-1,patt,str,dp);
        if(patt.charAt(i)=='*')
            return dp[i][j] = f(i-1,j,patt,str,dp) || f(i,j-1,patt,str,dp);
        return dp[i][j] = false;
    }
}