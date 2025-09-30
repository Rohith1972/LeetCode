class Solution {
    public void merge(int[] a, int n, int[] b, int m) {
        int[] res = new int[n+m];
        int i=0,j=0,k=0;
        while(i<n&&j<m){
            if(a[i]<b[j])
                res[k++]=a[i++];
            else
                res[k++]=b[j++];
        }
        while(i<n)
            res[k++] = a[i++];
        while(j<m)
            res[k++] = b[j++];
        for(int p=0;p<n+m;p++){
            a[p] = res[p];
        }
    }
}