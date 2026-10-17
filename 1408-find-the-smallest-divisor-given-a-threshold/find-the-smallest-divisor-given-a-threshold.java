class Solution {
    int maxi(int[] arr){
        int maxElem = Integer.MIN_VALUE;
        for(int i : arr){
            maxElem = Math.max(maxElem,i);
        }
        return maxElem;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxi(nums);
        int ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            int sum = calSum(nums,mid);
            if(sum <= threshold){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    int calSum(int[] nums,int mid){
        int sum = 0;
        for(int i : nums){
            sum += Math.ceil((double)i/(double)mid);
        }
        return sum;
    }
}