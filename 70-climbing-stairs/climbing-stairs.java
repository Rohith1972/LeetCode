class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        int count = 2;
       for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
            count += dp[i];
       }
       return count;
    }
    static int count(int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        int left = count(n-1);
        int right = count(n-2);
        return left+right;
    }
}