class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp;
            temp = generateRow(i);
            res.add(temp); 
        }
        return res;
    }
    List<Integer> generateRow(int row){
        List<Integer> temp = new ArrayList<>();
        int result = 1;
        for(int i=0;i<row;i++){
            temp.add(result);
            result *= (row-i);
            result /= (i+1);
        }
        temp.add(result);
        return temp;
    }
}
