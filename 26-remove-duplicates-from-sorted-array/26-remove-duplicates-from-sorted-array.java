class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        int idx = 0;
        while(idx<nums.length){
            if(nums[idx]==nums[cur]){
                idx++;
            }else{
                nums[++cur] = nums[idx++];
            }
        }
        return cur+1;
    }
}