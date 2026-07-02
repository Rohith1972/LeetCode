class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        solve(0,board,res,n);
        return res.size();
    }
    void solve(int col,char[][] board,List<List<String>> res,int n){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(col+1,board,res,n);
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