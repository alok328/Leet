class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if(needle.length()==0){
            return 0;
        }
        int[] lps = new int[needle.length()];
        populatePrefixIndices(lps, needle);

        int i = 0;
        int j = 0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j==0){
                i++;
            }else{
                j = lps[j-1];
            }
            if(j==needle.length())
                return i-j;
        }
        return -1;
    }
    private static void populatePrefixIndices(int[] lps, String needle) {
        int i = 0;
        int j = 1;
        while(j<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                lps[j++] = ++i;
            }else if(i==0){
                lps[j++] = 0;
            }else{
                i = lps[i-1];
            }
        }
    }
}