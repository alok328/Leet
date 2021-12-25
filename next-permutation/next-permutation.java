class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length-1;
        while(r>0){
            if(nums[r-1]<nums[r]){
                int cur = r-1;
                int nextGreater = nums.length-1;
                while(nextGreater>=cur && nums[nextGreater]<=nums[cur]){
                    nextGreater--;
                }
                int temp = nums[cur];
                nums[cur] = nums[nextGreater];
                nums[nextGreater] = temp;
                break;
            }
            r--;
        }
        int l = r;
        r = nums.length-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}