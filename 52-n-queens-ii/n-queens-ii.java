class Solution {
    static int res = 0;
    public int totalNQueens(int n) {
        res = 0;
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        solve(0,board,n);
        return res;
    }
    void solve(int col,char[][] board,int n){
        if(col == n){
            res++;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(col+1,board,n);
                board[row][col] = '.';
            }
        }
    }
    boolean isSafe(int row,int col,char[][] board,int n){
        for(int p=0;p<col;p++){
            if(board[row][p]=='Q')
                return false;
        }
        int i=row;
        int j =col;
        while(i>=0&&j>=0){
            if(board[i][j]=='Q')
                return false;
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i!=board.length&&j>=0){
            if(board[i][j]=='Q')
                return false;
            i++;
            j--;
        }
        return true;
    }
}