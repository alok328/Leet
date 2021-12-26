class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = 0;
        while(mid<=hi){
            if(nums[mid]==0){
                swap(lo, mid, nums);
                lo++;
                mid++;
            }else if(nums[mid]==2){
                swap(mid, hi, nums);
                hi--;
            }else{
                mid++;
            }
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}