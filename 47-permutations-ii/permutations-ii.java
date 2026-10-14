class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        Arrays.sort(nums);
        permutations(new ArrayList<>(),nums,map,res);
        return res; 
    }
    void permutations(List<Integer> ds,int[] nums,boolean[] map,List<List<Integer>> res){
        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(map[i]){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !map[i-1]){
                continue;
            }
            if(!map[i]){
                ds.add(nums[i]);
                map[i] = true;
                permutations(ds,nums,map,res);
                ds.remove(ds.size()-1);
                map[i] = false;
            }
        }
    }
}