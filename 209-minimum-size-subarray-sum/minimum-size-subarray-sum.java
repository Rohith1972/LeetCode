class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int j = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            while(sum >= target){
                minLength = Math.min(minLength,i-j+1);
                sum -= arr[j];
                j++;
            }
        }
        return (minLength == Integer.MAX_VALUE)?0:minLength;
    }
}