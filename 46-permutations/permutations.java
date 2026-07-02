class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean freq[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        recurPermute(nums,new ArrayList<>(),res,freq);
        return res;
    }
    void recurPermute(int[] nums,List<Integer> ds,List<List<Integer>> res,boolean[] freq){
        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                ds.add(nums[i]);
                freq[i]=true;
                recurPermute(nums,ds,res,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}