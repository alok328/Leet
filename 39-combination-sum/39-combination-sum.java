class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    
    private void solve(int idx, int tar, int[] nums, List<List<Integer>> ans, List<Integer> cur){
        if(idx==nums.length){
            if(tar==0){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        if(nums[idx]<=tar){
            cur.add(nums[idx]);
            solve(idx, tar-nums[idx], nums, ans, cur);
            cur.remove(cur.size()-1);
        }
        solve(idx+1, tar, nums, ans, cur);
    }
}