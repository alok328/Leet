class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<m; i++){
            if(nums2.length>0 && nums1[i]>nums2[0]){
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                int idx = 0;
                while(idx+1<nums2.length && nums2[idx]>nums2[idx+1]){
                    temp = nums2[idx];
                    nums2[idx] = nums2[idx+1];
                    nums2[idx+1] = temp;
                    idx++;
                }
            }
        }
        for(int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
    }
}