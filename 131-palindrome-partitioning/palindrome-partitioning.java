class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partition(0,s,ds,res);
        return res;
    }
    void partition(int index,String s,List<String> ds,List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                partition(i+1,s,ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(!(s.charAt(left++)==s.charAt(right--)))
                return false;
        }
        return true;
    }
}