class Solution {
    public int minOperations(int n) {
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = (2*i)+1;
        }
        int mid = arr[n/2];
        int res = 0;
        for(int i=0;i<n;i++){
            res += Math.abs(arr[i]-mid);
        }
        return res/2;
    }
}