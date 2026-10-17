class Solution {
    int maxi(int[] arr){
        int maxElem = Integer.MIN_VALUE;
        for(int i : arr){
            maxElem = Math.max(maxElem,i);
        }
        return maxElem;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxi(piles);
        int ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            int totalH = calTotH(piles,mid);
            if(totalH <= h){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    int calTotH(int[] piles,int k){
        int hrs = 0;
        for(int i : piles){
            hrs += Math.ceil((double)i/(double)k);
        }
        return hrs;
    }
}