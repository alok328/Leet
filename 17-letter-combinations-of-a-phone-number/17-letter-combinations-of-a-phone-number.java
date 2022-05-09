class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    
    private void solve(List<String> ans, String digits, int pos, List<Character> cur) {
        if(pos==digits.length()){
            ans.add(cur.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }
        List<Character> l = map.get(digits.charAt(pos));
        for(int i=0; i<l.size(); i++) {
            cur.add(l.get(i));
            solve(ans, digits, pos+1, cur);
            cur.remove(cur.size()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        initializeMap();
        List<String> ans = new ArrayList<>();
        solve(ans, digits, 0, new ArrayList<>());
        return ans;
    }
    
    private void initializeMap() {
        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));
    }
}