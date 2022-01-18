class Solution {
    int[] memoFact;
    
    private int findFactorial(int n){
        if(memoFact[n]!=-1){
            return memoFact[n];
        }
        if(n==0 || n==1){
            memoFact[n] = n;
            return memoFact[n];
        }
        memoFact[n] = n * findFactorial(n-1);
        return memoFact[n];
    }
    
    private void solve(int n, int k, List<Integer> choices, char[] s, int idx){
        if(n==1){
            s[idx++] = (char)(choices.get(n-1)+48);
            return;
        }
        int totalPerms = findFactorial(n);
        int groupSize = totalPerms/n;
        int requiredPermIdx = (k-1)/groupSize;
        s[idx++] = (char)(choices.get(requiredPermIdx)+48);
        choices.remove(requiredPermIdx);
        solve(n-1, k-(groupSize*requiredPermIdx), choices, s, idx);
        return;
    }
    
    public String getPermutation(int n, int k) {
        memoFact = new int[400000];
        Arrays.fill(memoFact, -1);
        char[] s = new char[n];
        List<Integer> choices = new ArrayList<>();
        for(int i=1; i<=n; i++){
            choices.add(i);
        }
        solve(n, k, choices, s, 0);
        return String.valueOf(s);
    }
}