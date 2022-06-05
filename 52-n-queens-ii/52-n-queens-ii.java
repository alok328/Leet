class Solution {
    int ans = 0;
    
    private boolean safeToPlace(int r, int c, int n, int[][] board){
        for(int i=0; i<n; i++){
            if(board[r][i]==1 || board[i][c]==1){
                return false;
            }
        }
        for(int i=r, j=c; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=r, j=c; i>=0 && j<n; i--, j++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    
    private void placeQueens(int[][] board, int n, int r) {
        if(r==n) {
            ans++;
            return;
        }
        for(int c=0; c<n; c++) {
            if(safeToPlace(r, c, n, board)) {
                board[r][c] = 1;
                placeQueens(board, n, r+1);
                board[r][c] = 0;
            }
        }
    }
    
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, n, 0);
        return ans;
    }
}