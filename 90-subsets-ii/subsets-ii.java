class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subset(0,nums,new ArrayList<>(),res);
        return res;
    }
    void subset(int index,int[] nums,ArrayList<Integer> ds,List<List<Integer>> res){
        res.add(new ArrayList<>(ds));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i] == nums[i-1])
                continue;
            ds.add(nums[i]);
            subset(i+1,nums,ds,res);
            ds.remove(ds.size()-1);
        }
    }
}