class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxCards=0,lsum=0,rsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        maxCards = lsum;
        int rindex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex--;
            maxCards = Math.max(maxCards,lsum+rsum);
        }
        return maxCards;
    }
}