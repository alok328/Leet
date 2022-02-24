class Solution {
    public String getSay(String count){
        String res = "";
        int c = 1;
        int i;
        for(i=1; i<count.length(); i++){
            if(count.charAt(i)==count.charAt(i-1)){
                c++;
            }else{
                res = res + String.valueOf(c) + count.charAt(i-1);
                c = 1;
            }
        }
        res = res + String.valueOf(c) + count.charAt(i-1);
        return res;
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String count_n_1 = countAndSay(n-1);
        return getSay(count_n_1);
    }
}