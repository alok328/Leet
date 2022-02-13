class Solution {
    public int countSubstrings(String s) {
        int maxCount = 0;
        for(int i=0; i<s.length(); i++){
            int count1 = expand(s, i, i);
            int count2 = expand(s, i, i+1);
            maxCount += count1 + count2;
        }
        return maxCount;
    }
    
    private int expand(String s, int left, int right){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}