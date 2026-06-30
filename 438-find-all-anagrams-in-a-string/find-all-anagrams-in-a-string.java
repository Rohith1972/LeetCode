class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(Character ch:p.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count = hm.size();
        int k = p.length();
        for(int i=0;i<s.length();i++){
            char incoming = s.charAt(i);
            if(hm.containsKey(incoming)){
                hm.put(incoming,hm.get(incoming)-1);
                if(hm.get(incoming)==0){
                    count--;
                }
            }
            if(i<k-1)
                continue;
            if(count==0)
                res.add(i-k+1);
            char outgoing = s.charAt(i-k+1);
            if(hm.containsKey(outgoing)){
                hm.put(outgoing,hm.get(outgoing)+1);
                if(hm.get(outgoing)==1){
                    count++;
                }
            }
        }
        return res;
    }
}