class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] next = new int[2];
        for(int ind=prices.length-1;ind>=0;ind--){
            int[] cur = new int[2];
            cur[1] = Math.max(
                -prices[ind] + next[0],
                next[1]
            );
            cur[0] = Math.max(
                prices[ind]-fee+ next[1],
                next[0]
            );
            next = cur;
        }
        return next[1];
    }
}