class Solution {
    public int maxProduct(int[] nums) {
        int ans = Arrays.stream(nums)
                    .max()
                    .getAsInt();
        int min=1;
        int max=1;
        for(int n : nums){
            if(n==0){
                min = 1;
                max = 1;
                continue;
            }
            int temp = min;
            min = Math.min(n*min, Math.min(n*max, n));
            max = Math.max(n*temp, Math.max(n*max, n));
            ans = Math.max(min, Math.max(max, ans));
        }
        return ans;
    }
}