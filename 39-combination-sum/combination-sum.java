class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        find(0,target,new ArrayList<>(),candidates,res);
        return res;
    }
    void find(int ind,int target,ArrayList<Integer> ds,int[] arr,List<List<Integer>> res){

        if(ind == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return ;
        }

        if(arr[ind] <= target){
            ds.add(arr[ind]);
            find(ind,target-arr[ind],ds,arr,res);
            ds.remove(ds.size()-1);
        }
        find(ind+1,target,ds,arr,res);
    }
}