class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = calMaxi(weights);
        int sum = calSum(weights);
        int low = maxi;
        int high = sum;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int requiredDays = calReqDays(weights,mid);
            System.out.println(requiredDays);
            System.out.println(mid);
            if(requiredDays <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    int calReqDays(int[] weights , int mid){
        int daysReq = 0;
        int load = 0;
        for(int i : weights){
            if(load+i > mid){
                daysReq++;
                load = i;
            }else{
                load += i;
            }
        }
        daysReq++;
        return daysReq;
    }
    int calMaxi(int[] weights){
        int maxElem = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            maxElem = Math.max(maxElem,weights[i]);
        }
        return maxElem;
    }
    int calSum(int[] weights){
        int sum = 0;
        for(int i : weights){
            sum += i;
        }
        return sum;
    }
}