class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            
            int[] freq = new int[26];
            for(char c : chars){
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : freq){
                sb.append('#').append(i);
            }
            map.computeIfAbsent(sb.toString() , k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}