class Solution {
    private void solve(int idx, int tsum, int[] arr, List<List<Integer>> ans, List<Integer> cur){
    if(idx==arr.length){
      if(tsum==0){
        ans.add(new ArrayList<>(cur));
      }
      return;
    }
    if(arr[idx]<=tsum) {
      cur.add(arr[idx]);
      solve(idx, tsum - arr[idx], arr, ans, cur);
      cur.remove(cur.size() - 1);
    }
    solve(idx+1, tsum, arr, ans, cur);
  }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, arr, ans, new ArrayList<>());
        return ans;
    }
}