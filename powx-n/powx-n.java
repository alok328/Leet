class Solution {
    public double myPow(double x, int n) {
        boolean negative = n<0 ? true : false;
        long exp = n;
        if(negative){
            exp = -1*(long)n;
        }
        double ans = 1.0;
        while(exp>0){
            if(exp%2==0){
                x *= x;
                exp /= 2;
            }else{
                ans *= x;
                exp -= 1;
            }
        }
        return negative ? 1.0/ans : ans;
    }
}