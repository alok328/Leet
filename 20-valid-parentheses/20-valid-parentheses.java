class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
        );
        Stack<Character> seen = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(seen.isEmpty()){
                //(
                seen.push(s.charAt(i));
            }else{
                if(map.containsKey(s.charAt(i))){
                    if(map.get(s.charAt(i))==seen.peek()){
                        seen.pop();
                    }else{
                        return false;
                    }
                }else{
                    seen.push(s.charAt(i));
                }
            }
        }
        return seen.isEmpty();
    }
}