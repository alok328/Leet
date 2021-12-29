class Solution {
    public int uniquePaths(int m, int n) {
        return traverse(0, 0, m, n, new int[m][n]);
    }
    private int traverse(int i, int j, int m, int n, int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 || j==n-1){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j] = traverse(i+1, j, m, n, dp) + traverse(i, j+1, m, n, dp);
        return dp[i][j];
    }
}