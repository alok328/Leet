class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //rotate
        for(int i=0; i<n; i++){
            int lo = 0;
            int hi = n-1;
            while(lo<hi){
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;
                lo++;
                hi--;
            }
        }
    }
}