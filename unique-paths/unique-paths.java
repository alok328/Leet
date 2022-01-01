class Solution {
    public int uniquePaths(int m, int n) {
        int totalSteps = m+n-2; 
        int downSteps = m-1; 
        double ans = 1;
        for(int i=0; i<downSteps; i++){
            ans = ans*(totalSteps-downSteps+(i+1))/(i+1);
        }
        return (int)ans;
    }
}