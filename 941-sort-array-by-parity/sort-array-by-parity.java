class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }
        int index=0;
        for(int i=0;i<even.size();i++){
            res[index++] = even.get(i);
        }
        for(int i=0;i<odd.size();i++){
            res[index++] = odd.get(i);
        }
        return res;
    }
}