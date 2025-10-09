class Solution {
    public int singleNumber(int[] arr) {
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],1);
            else
                hm.put(arr[i],hm.get(arr[i])+1);
        }
        Set<Integer> st = hm.keySet();
        int res = 0;
        for(Integer i : st){
            if(hm.get(i)==1){
                res=i;
                break;
            }
        }
        return res;
    }
}