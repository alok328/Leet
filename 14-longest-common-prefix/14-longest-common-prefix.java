class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int idx = 0;
        while(true){
            if(idx>=strs[0].length()){
                break;
            }
            char c = strs[0].charAt(idx);
            boolean match = true;
            for(int i=1; i<strs.length; i++){
                if(idx>=strs[i].length() || strs[i].charAt(idx) != c){
                    match = false;
                    break;
                }
            }
            if(!match){
                break;
            }
            idx++;
        }
        return strs[0].substring(0, idx);
    }
}