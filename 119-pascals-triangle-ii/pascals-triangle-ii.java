class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long res = 1;
        result.add((int)res);
        for(int i=0;i<rowIndex;i++){
            res *= (rowIndex-i);
            res /= (i+1);
            result.add((int)res);
        }
        return result;
    }
}