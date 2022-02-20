class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String s : strs){
            minLen = Math.min(minLen, s.length());
        }
        int lo = 0;
        int hi = minLen-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isCommonPrefix(strs, mid)){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return strs[0].substring(0, (lo+(hi-lo)/2));
    }
    private boolean isCommonPrefix(String[] strs, int len){
        String str = strs[0].substring(0, len+1);
        for(int i=1; i<strs.length; i++){
            if(!strs[i].startsWith(str)){
                return false;
            }
        }
        return true;
    }
}