class Solution {
    Integer[] memo = new Integer[38];
    public int tribonacci(int n) {
        if(memo[n]!=null) {
            return memo[n];
        }
        if(n==0) {
            memo[n] = 0;
            return 0;
        }
        if(n==1 || n==2) {
            memo[n] = 1;
            return 1;
        }
        memo[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        return memo[n];
    }
}