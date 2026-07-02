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
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr = curr.child[ch-'a'];
        }
        return curr.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr = curr.child[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */