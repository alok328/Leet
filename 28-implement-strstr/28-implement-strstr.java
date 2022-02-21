class Solution {
    public int strStr(String haystack, String needle) {
        int window = needle.length();
        int needleHash = getHash(needle);
        for(int i=0; i<=haystack.length()-window; i++){
            if(getHash(haystack.substring(i, i+window))==needleHash){
                return i;
            }
        }
        return -1;
    }
    
    private int getHash(String s){
        return s.hashCode();
    }
}