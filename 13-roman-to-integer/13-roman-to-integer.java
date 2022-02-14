class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romToInt = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='I'){
                int cur = 0;
                if(i+1<s.length() && s.charAt(i+1)=='I'){
                    while(i<s.length() && s.charAt(i)=='I'){
                        cur+=1;
                        i++;
                    }
                }else if(i==s.length()-1){
                    cur+=1;
                }else{
                    cur+=romToInt.get(s.charAt(++i));
                    cur-=1;
                }
                ans+=cur;
            }else if(i!=s.length()-1){
                if(romToInt.get(s.charAt(i))<romToInt.get(s.charAt(i+1))){
                    ans += romToInt.get(s.charAt(i+1));
                    ans -= romToInt.get(s.charAt(i));
                    i++;
                }else{
                    ans += romToInt.get(s.charAt(i));
                }
            }else{
                ans+=romToInt.get(s.charAt(i));
            }
        }
        return ans;
    }
}