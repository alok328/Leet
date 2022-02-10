class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                if(temp.length()>0){
                    stack.push(temp);
                }
                temp = "";
            }else{
                temp+=s.charAt(i);
            }
        }
        if(temp.length()>0){
            stack.push(temp);
        }
        temp = "";
        int size = stack.size();
        for(int i=0; i<size; i++){
            temp+=stack.pop();
            if(i!=size-1){
                temp+=" ";
            }
        }
        return temp;
    }
}