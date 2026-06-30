class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count = map.size();
        int k = s1.length();
        int n = s2.length();
        for(int i=0;i<n;i++){
            char incoming = s2.charAt(i);
            if(map.containsKey(incoming)){
                map.put(incoming,map.get(incoming)-1);
                if(map.get(incoming)==0){
                    count--;
                }
            }
            if(i<k-1)
                continue;
            if(count==0){
                return true;
            }
            char outgoing = s2.charAt(i-k+1);
            if(map.containsKey(outgoing)){
                map.put(outgoing,map.get(outgoing)+1);
                if(map.get(outgoing)==1){
                    count++;
                }
            }
        }
        return false;
    }
}