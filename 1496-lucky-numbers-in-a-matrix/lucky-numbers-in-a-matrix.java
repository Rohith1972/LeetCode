class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        LinkedHashMap<Integer,Integer> hs = new LinkedHashMap<>();
        for(int i=0;i<matrix.length;i++){
            int rowMin=999999;
            int minIndex=Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<rowMin){
                    rowMin=matrix[i][j];
                    minIndex=j;
                }
            }
            hs.put(rowMin,minIndex);
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : hs.entrySet()){
            int j = e.getValue();
            int maxValue=-1;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]>maxValue)
                    maxValue = matrix[i][j];
            } 
            if(maxValue == e.getKey())
                res.add(maxValue);
        }
        return res;
    }
}