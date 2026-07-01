class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combination(0,candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    void combination(int index,int[] candidates,int target,int sum,ArrayList<Integer> ds,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                break;
            ds.add(candidates[i]);
            combination(i+1,candidates,target-candidates[i],sum+candidates[i],ds,res);
            ds.remove(ds.size()-1);
        }
    }
}