class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, ans, new ArrayList<>());
        return ans;
    }
    
    private void solve(int idx, String s, List<List<String>> ans, List<String> cur){
        if(idx==s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s.substring(idx, i+1))){
                cur.add(s.substring(idx, i+1));
                solve(i+1, s, ans, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}