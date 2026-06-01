class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low <= high){
            int temp = numbers[low]+numbers[high];
            if(temp == target)
                return new int[]{low+1,high+1};
            else if(temp<target)
                low++;
            else
                high--;
        }
        return new int[]{-1,-1};
    }
}