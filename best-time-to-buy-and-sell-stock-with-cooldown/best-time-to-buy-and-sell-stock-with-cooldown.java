class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(prices, dp, 0, true);
    }
    
    private int solve(int[] prices, Map<String, Integer> dp, int day, boolean buying) {
        if (day >= prices.length) {
            return 0;
        }
        String key = "" + day + buying;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(buying){
            int buy = solve(prices, dp, day+1, false) - prices[day];
            int cooldown = solve(prices, dp, day+1, true);
            dp.put(key, Math.max(buy, cooldown));
        }else{
            int sell = solve(prices, dp, day+2, true) + prices[day];
            int cooldown = solve(prices, dp, day+1, false);
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }
}