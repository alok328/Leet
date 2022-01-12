class Solution {
    private void findSubsets(List<List<Integer>> ans, int[] nums, int idx, List<Integer> cur){
        ans.add(new ArrayList<>(cur));
        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            findSubsets(ans, nums, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(ans, nums, 0, new ArrayList<>());
        return ans;
    }
}