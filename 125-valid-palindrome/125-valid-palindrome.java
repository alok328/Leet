class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";
        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                temp+=s.charAt(i);
            }else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                temp+=Character.toLowerCase(s.charAt(i));
            }else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                temp+=s.charAt(i);
            }
        }
        return isPal(temp);
    }
    
    private boolean isPal(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}