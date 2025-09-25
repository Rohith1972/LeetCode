class Solution {
    public int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            int res = arr[i]+arr[j];
            if(res==target)
                return new int[]{i+1,j+1};
            else if(res<target)
                i++;
            else
                j--;
        }
        return new int[]{-1,-1};
    }
}