class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subset(0,nums,new ArrayList<>(),res);
        return res;
    }
    void subset(int index,int[] nums,ArrayList<Integer> ds,List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        subset(index+1,nums,ds,res);
        ds.remove(ds.size()-1);
        subset(index+1,nums,ds,res);
    }
}