class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurPermute(0,nums,res);
        return res;
    }
    void recurPermute(int index,int[] nums,List<List<Integer>> res){
        if(index == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            res.add(ds);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            recurPermute(index+1,nums,res);
            swap(index,i,nums);
        }
    }
    void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}