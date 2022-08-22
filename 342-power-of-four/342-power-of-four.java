class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<0)
            return false;
        int setBits = 0;
        int posOfSetBit = 0;
        int idx = 1;
        while(n>0) {
            if((n&1)==1) {
                setBits++;
                posOfSetBit = idx;
            }
            idx++;
            n = n>>1;
        }
        return setBits==1 && posOfSetBit%2==1;
    }
}