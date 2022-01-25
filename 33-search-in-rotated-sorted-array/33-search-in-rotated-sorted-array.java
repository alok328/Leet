class Solution {
    private int findMinElementIdx(int[] nums, int lo, int hi){
        int n = nums.length;
        while(lo<=hi){
            if(nums[lo]<=nums[hi]){
                return lo;
            }
            int mid = (lo+hi)/2;
            int prev = (n+mid-1)%n;
            int next = (mid+1)%n;
            if(nums[prev]>=nums[mid] && nums[next]>=nums[mid]){
                return mid;
            }
            if(nums[lo]<=nums[mid]){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }
    
    private int binarySearch(int lo, int hi, int[] nums, int tar){
        if(lo>hi){
            return -1;
        }
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==tar){
                return mid;
            }else if(nums[mid]<tar){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivot = findMinElementIdx(nums, 0, nums.length-1);
        int leftHalfSearch = binarySearch(0, pivot-1, nums, target);
        int rightHalfSearch = binarySearch(pivot, nums.length-1, nums, target);
        return leftHalfSearch==-1 ? rightHalfSearch : leftHalfSearch;
    }
}