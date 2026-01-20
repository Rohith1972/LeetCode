class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int l[] = new int[n];
        int r[] = new int[n];
        Arrays.fill(l,1);
        Arrays.fill(r,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                l[i] += l[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                r[i] += r[i+1];
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res += Math.max(l[i],r[i]);
        }  
        return res;       
    }
}