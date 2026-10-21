class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        find(0,target,new ArrayList<>(),candidates,res);
        return res;
    }   
    void find(int ind,int target,ArrayList<Integer> ds,int[] arr,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            find(i+1,target-arr[i],ds,arr,res);
            ds.remove(ds.size()-1);
        }
    }
}