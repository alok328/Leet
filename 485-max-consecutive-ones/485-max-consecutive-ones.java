class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int ans = 0;
        for(int n : nums){
            if(n==0){
                sum=0;
            }else{
                sum+=1;
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }
}