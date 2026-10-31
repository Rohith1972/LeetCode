class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        fun(0,board,res,n);
        return res;
    }
    void fun(int col,char[][] board,List<List<String>> res,int n){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(col,row,board,n)){
                board[col][row] = 'Q';
                fun(col+1,board,res,n);
                board[col][row] = '.';
            }
        }
        return;
    }
    boolean isSafe(int col,int row,char[][] board,int n){
        for(int p=col;p>=0;p--){
            if(board[p][row] == 'Q'){
                return false;
            }
        }
        int i=col,j=row;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i=col;
        j=row;
        while(i>=0 && j<n){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}