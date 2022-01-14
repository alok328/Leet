class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    
    private void solve(int idx, int tar, int[] nums, List<List<Integer>> ans, List<Integer> cur){
        if(tar==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]<=tar){
                cur.add(nums[i]);
                solve(i+1, tar-nums[i], nums, ans, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}