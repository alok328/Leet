class Solution {
    Set<Integer> cost = new HashSet<>();
    int minDiff = Integer.MAX_VALUE;
    
    private void solve(int[] tc, int target, int idx, int amount){
        if(idx>=tc.length){
            cost.add(amount);
            minDiff = Math.min(minDiff, Math.abs(target-amount));
            return;
        }
        solve(tc, target, idx+1, amount);
        solve(tc, target, idx+1, amount+tc[idx]);
        solve(tc, target, idx+1, amount+tc[idx]*2);
    }
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i=0; i<baseCosts.length; i++){
            solve(toppingCosts, target, 0, baseCosts[i]);
        }
        if(cost.contains(target-minDiff)){
            return target-minDiff;
        }
        return target+minDiff;
    }
}