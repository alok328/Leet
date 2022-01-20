class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char k='1'; k<='9'; k++){
                        if(canPlace(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean canPlace(char[][] board, int r, int c, char k){
        int boxStartR = (r/3)*3;
        int boxStartC = (c/3)*3;
        for(int i=boxStartR; i<boxStartR+3; i++){
            for(int j=boxStartC; j<boxStartC+3; j++){
                if(board[i][j]==k){
                    return false;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(board[i][c]==k || board[r][i]==k){
                return false;
            }
        }
        return true;
    }
}