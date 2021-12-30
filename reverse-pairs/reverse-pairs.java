class Solution {
    public int reversePairs(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    private int divide(int[] nums, int lo, int hi){
        if(lo>=hi){
            return 0;
        }
        int mid = lo + (hi-lo)/2;
        int leftCount = divide(nums, lo, mid);
        int rightCount = divide(nums, mid+1, hi);
        return leftCount + rightCount + count(nums, lo, mid, hi);
    }
    private int count(int[] nums, int lo, int mid, int hi){
        int i, j=mid+1, k=0;
        int revCount = 0;
        for(i=lo; i<=mid; i++){
            while(j<=hi && nums[i]>(2*(long)nums[j])){
                j++;
            }
            revCount += (j - (mid+1));
        }
        i = lo;
        j = mid+1;
        int[] temp = new int[hi-lo+1];
        while(i<=mid && j<=hi){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=hi){
            temp[k++] = nums[j++];
        }
        k = 0;
        i = lo;
        while(i<=hi){
            nums[i++] = temp[k++];
        }
        return revCount;
    }
}