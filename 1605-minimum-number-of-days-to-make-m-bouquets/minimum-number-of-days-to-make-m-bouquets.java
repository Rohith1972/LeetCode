class Solution {
    int maxi(int[] arr){
        int maxElem = Integer.MIN_VALUE;
        for(int i : arr){
            maxElem = Math.max(maxElem,i);
        }
        return maxElem;
    }
    int calMaxBoquets(int[] bloomDay,int k,int mid){
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= mid){
                cnt++;
            }else{
                ans += cnt/k;
                cnt = 0;
            }
        }
        ans += cnt/k;
        return ans;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = maxi(bloomDay);
        System.out.println(high);
        if((long)m*k > bloomDay.length) return -1;
        int ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            int maxBoquets = calMaxBoquets(bloomDay,k,mid);
            if(maxBoquets >= m){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}