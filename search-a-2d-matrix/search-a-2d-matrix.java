class Solution {
    private boolean findInRow(int[] row, int tar){
        int lo = 0;
        int hi = row.length-1;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(row[mid]==tar){
                return true;
            }else if(row[mid]<tar){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix){
            if(row[row.length-1]==target){
                return true;
            }else if(row[row.length-1]>target){
                return findInRow(row, target);
            }
        }
        return false;
    }
}