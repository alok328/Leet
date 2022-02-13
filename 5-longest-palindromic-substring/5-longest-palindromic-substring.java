class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len>end-start+1){
                start = i - ((len-1)/2);
                end = i + (len/2);
            }
        }
        return s.substring(start, end+1);
    }
    
    private int expandFromMiddle(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}

// "racecar"

// "aaaaaa"
// i -> 2
// len -> 6
// start -> 2 - ((6-1)/2)
//          2 - 2 -> 0
// end -> 2 + 3 -> 5
