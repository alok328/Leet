class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(seen.contains(nums[i]-1) || seen.contains(nums[i]+1)){
                ans = Math.max(ans, checkForConsecutiveNumbers(nums, nums[i], seen));
            }
            seen.add(nums[i]);
            ans = Math.max(ans, 1);
        }
        return ans;
    }
    private int checkForConsecutiveNumbers(int[] nums, int start, Set<Integer> seen){
        int consCount = 1;
        int greater = start+1;
        int lesser = start-1;
        while(seen.contains(greater)){
            consCount+=1;
            greater+=1;
        }
        while(seen.contains(lesser)){
            consCount+=1;
            lesser-=1;
        }
        return consCount;
    }
}