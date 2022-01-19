class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<char[]> board =  new ArrayList<>();
        for(int i=0; i<n; i++){
            board.add(new char[n]);
            Arrays.fill(board.get(i), '.');
        }
        List<List<String>> ans = new ArrayList<>();
        fillBoard(0, n, board, ans);
        return ans;
    }
    
    private void fillBoard(int row, int n, List<char[]> board, List<List<String>> ans){
        if(row==n){
            addBoardToAns(board, ans);
            return;
        }
        for(int i=0; i<n; i++){
            if(safeToPlace(row, i, n, board)){
                board.get(row)[i] = 'Q';
                fillBoard(row+1, n, board, ans);
                board.get(row)[i] = '.';
            }
        }
    }
    
    private boolean safeToPlace(int r, int c, int n, List<char[]> cur){
        for(int i=0; i<n; i++){
            if(cur.get(r)[i]=='Q' || cur.get(i)[c]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c; i>=0 && j>=0; i--, j--){
            if(cur.get(i)[j]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c; i>=0 && j<n; i--, j++){
            if(cur.get(i)[j]=='Q'){
                return false;
            }
        }
        return true;
    }
    
    private void addBoardToAns(List<char[]> board, List<List<String>> ans){
        List<String> row = new ArrayList<>();
        for(int i=0; i<board.size(); i++){
            row.add(String.valueOf(board.get(i)));
        }
        ans.add(row);
    }
}