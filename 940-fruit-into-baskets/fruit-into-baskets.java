class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left=0,right=0,maxLength=0;
        while(right<fruits.length){
            hm.put(fruits[right],hm.getOrDefault(fruits[right],0)+1);
            if(hm.size()>2){
                while(hm.size()>2){
                    hm.put(fruits[left],hm.get(fruits[left])-1);
                    System.out.println(fruits[left]);
                    if(hm.get(fruits[left])==0)
                        hm.remove(fruits[left]);
                    left++;
                }
            }
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}