class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(0,nums,res);
        return res;
    }
    void permutations(int ind,int[] nums,List<List<Integer>> res){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            res.add(ds);
        }
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            permutations(ind+1,nums,res);
            swap(i,ind,nums);
        }
        return;
    }
    
    void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}