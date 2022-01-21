class Solution {
    Map<String, Boolean> seen;
    public boolean wordBreak(String s, List<String> wordDict) {
        seen = new HashMap<>();
        return solve(s, wordDict.stream().collect(Collectors.toSet()));
    }
    
    private boolean solve(String s, Set<String> dict){
        if(dict.contains(s)){
            seen.put(s, true);
            return seen.get(s);
        }
        if(seen.containsKey(s)){
            return seen.get(s);
        }
        for(int i=0; i<s.length(); i++){
            if(dict.contains(s.substring(0, i+1))){
                if(solve(s.substring(i+1), dict)){
                    seen.put(s, true);
                    return seen.get(s);
                }
            }
        }
        seen.put(s, false);
        return seen.get(s);
    }
}