class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<=nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int cur = nums[i];
            int required = 0-cur;
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi){
                if(nums[lo]+nums[hi]==required){
                    List<Integer> valid = List.of(cur, nums[lo], nums[hi]);
                    ans.add(valid);
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }else if(nums[lo]+nums[hi]>required){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        return ans;
    }
}