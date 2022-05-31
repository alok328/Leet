class Solution {
    public boolean hasAllCodes(String s, int k) {
        int requiredCodeCount = 1<<k;
        Set<String> foundCodes = new HashSet<>();
        for(int i=k; i<=s.length(); i++) {
            String code = s.substring(i-k, i);
            if(!foundCodes.contains(code)) {
                foundCodes.add(code);
                requiredCodeCount--;
                if(requiredCodeCount==0){
                    return true;
                }
            }
        }
        return false;
    }
}