class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<k; i++){
            for(int j=0; j<m; j++){
                for(int l=0; l<n; l++){
                    int temp = grid[0][0];
                    grid[0][0] = grid[j][l];
                    grid[j][l] = temp;
                }
            }
        }
        for(int i=0; i<m; i++){
            ans.add(new ArrayList<>());
            for(int j=0; j<n; j++){
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }
}