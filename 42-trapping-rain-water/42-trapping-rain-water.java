class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lm = new int[n];
        lm[0] = height[0];
        int[] rm = new int[n];
        rm[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            lm[i] = Math.max(lm[i-1], height[i]);
        }
        for(int i=n-2; i>=0; i--){
            rm[i] = Math.max(rm[i+1], height[i]);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(lm[i], rm[i]);
            ans += min>height[i] ? min-height[i] : 0;
        }
        return ans;
    }
}