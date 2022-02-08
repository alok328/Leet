class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int total = 0;
        int count = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!=0) total++;
                if(grid[i][j]==2) rotten.offer(new int[] {i, j});
            }
        }
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        while(!rotten.isEmpty()){
            int size=rotten.size();
            count += size;
            while(size-- > 0){
                int[] cell = rotten.poll();
                for(int d=0; d<di.length; d++){
                    int i = cell[0]+di[d];
                    int j = cell[1]+dj[d];
                    if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=1){
                        continue;
                    }
                    grid[i][j] = 2;
                    rotten.offer(new int[] {i, j});
                }
            }
            if(!rotten.isEmpty()){
                time++;
            }
        }
        return count==total ? time : -1;
    }
}