class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        boolean neg = false;
        int i = 0;
        if(s.charAt(i)=='-'){
            neg = true;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        String num = "";
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                num+=s.charAt(i);
            }else{
                break;
            }
            i++;
        }
        long ans = 0;
        for(i=0; i<num.length(); i++){
            if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE){
                break;
            }
            ans = ans + (long)(Math.pow(10, num.length()-1-i)*(((int)num.charAt(i))-48));
        }
        if(neg){
            ans = -1*ans;
        }
        return ans>Integer.MAX_VALUE ? Integer.MAX_VALUE : (ans<Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) ans);
    }
}