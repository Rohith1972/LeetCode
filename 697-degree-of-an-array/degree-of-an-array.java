class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> last = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            if(!first.containsKey(nums[i]))
                first.put(nums[i],i);
            last.put(nums[i],i);
        }
        int minLength = nums.length;
        int degree = Collections.max(count.values());
        for(int i : count.keySet()){
            if(count.get(i) == degree){
                int len = last.get(i) - first.get(i) + 1;
                minLength = Math.min(len,minLength);
            }
        }
        return minLength;
    }
}