class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combination(0,candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    void combination(int index,int[] candidates,int target,int sum,ArrayList<Integer> ds,List<List<Integer>> res){
        if(index == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            combination(index,candidates,target-candidates[index],sum+candidates[index],ds,res);
            ds.remove(ds.size()-1);
        }
        combination(index+1,candidates,target,sum,ds,res);
    }
}