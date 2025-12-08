class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,mid,l,r);
        }
    }
    static void merge(int[] arr,int m,int l,int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = arr[i+l];
        }
        for(int i=0;i<n2;i++){
            R[i] = arr[m+i+1];
        }
        int i=0,j=0;
        int k = l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while(i<n1){
            arr[k++] = L[i++];
        }
        while(j<n2){
            arr[k++] = R[j++];
        }
    }
}