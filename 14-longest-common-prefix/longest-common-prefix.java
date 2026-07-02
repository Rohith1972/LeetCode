class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String s : strs){
            if(s.equals(""))
                return new String("");
            trie.insert(s);
        }
        String prefix = trie.commonPrefix();
        return prefix;
    }
}
class TrieNode{
    TrieNode child[];
    boolean isLeaf;
    int count;
    TrieNode(){
        child = new TrieNode[26];
        isLeaf = false;
        count = 0;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a'] = new TrieNode();
            }
            curr.child[ch-'a'].count++;
            curr = curr.child[ch-'a'];
        }
        curr.isLeaf = true;
    }
    String commonPrefix(){
        TrieNode curr = root;
        StringBuilder res = new StringBuilder();
        while(true){
            int count = 0;
            int nextIndex = -1;
            for(int i=0;i<26;i++){
                if(curr.child[i]!=null){
                    count++;
                    nextIndex = i;
                }
            }
            if(count != 1){
                break;
            }
            curr = curr.child[nextIndex];
            res.append((char)('a'+nextIndex));
            if(curr.isLeaf)
                break;
        }
        return res.toString();
    }
}
