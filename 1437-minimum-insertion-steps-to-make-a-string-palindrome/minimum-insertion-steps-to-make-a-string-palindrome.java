class Solution {
    public int minInsertions(String s1) {
        String s2 = reverse(s1);
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return n - solve(n-1,n-1,s1,s2,dp);
    }
    public String reverse(String s){
        StringBuilder temp = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            temp.append(String.valueOf(s.charAt(i)));
        }
        return temp.toString();
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