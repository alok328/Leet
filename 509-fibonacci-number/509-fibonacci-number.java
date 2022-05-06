class Solution {
    int[] memo;
    public int fib(int n) {
        if(n==0||n==1) {
            return n;
        }
        memo = new int[n+1];
        helper(n);
        return memo[n];
    }
    
    private int helper(int n) {
        if(n==0 || memo[n]!=0) {
            return memo[n];
        }
        if(n<0){
            return 0;
        }
        if(n==0 || n==1) {
            return n;
        }
        memo[n] = helper(n-1) + helper(n-2);
        return memo[n];
    }
}