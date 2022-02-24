class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            int idx = (int) s.charAt(i) - 97;
            count[idx]++;
        }
        for(int i=0; i<t.length(); i++){
            int idx = (int) t.charAt(i) - 97;
            if(count[idx]==0){
                return false;
            }
            count[idx]--;
        }
        for(int i=0; i<26; i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}