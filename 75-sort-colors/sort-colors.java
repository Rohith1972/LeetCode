class Solution {
    public void sortColors(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0)
                zeroCount++;
            else if(arr[i] == 1)
                oneCount++;
            else
                twoCount++;
        }
        int index=0;
        for(int j=0;j<zeroCount;j++){
            arr[index++]=0;
        }
        for(int j=0;j<oneCount;j++){
            arr[index++]=1;
        }
        for(int j=0;j<twoCount;j++){
            arr[index++]=2;
        }
    }
}