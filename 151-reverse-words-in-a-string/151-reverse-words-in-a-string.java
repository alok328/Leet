class Solution {
    public String reverseWords(String s) {
        List<String> strings = new ArrayList<>();
        String temp = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' '){
                if(temp!=""){
                    strings.add(temp);
                }
                temp = "";
                continue;
            }
            temp+=c;
        }
        if(temp!=""){
            strings.add(temp);
        }
        String res = "";
        for(int i=strings.size()-1; i>=0; i--){
            res+=strings.get(i);
            if(i!=0){
                res+=" ";
            }
        }
        return res;
    }
}