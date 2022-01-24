class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n-2;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(mid%2==0){
                if(nums[mid]!=nums[mid+1]){
                    //we are in right half
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{
                if(nums[mid]!=nums[mid+1]){
                    //we are in the left half
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return nums[lo];
    }
}