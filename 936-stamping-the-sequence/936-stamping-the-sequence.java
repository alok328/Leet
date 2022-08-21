class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] st = stamp.toCharArray();
        char[] tr = target.toCharArray();
        
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[target.length()];
        int stars = 0;
        
        while(stars<target.length()) {
            boolean done = false;
            for(int i=0; i<=tr.length-st.length; i++) {
                if(!vis[i] && canReplace(st, tr, i)) {
                    stars += replace(st, tr, i);
                    
                    done = true;
                    vis[i] = true;
                    ans.add(i);
                    if(stars==tr.length) {
                        break;
                    }
                }
            }
            if(!done) {
                return new int[0];
            }
        }
        
        int[] res = new int[ans.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = ans.get(ans.size()-1-i);
        }
        return res;
    }
    
    private boolean canReplace(char[] st, char[] tr, int p) {
        for(int i=0; i<st.length; i++) {
            if(tr[i+p]!='*' && tr[i+p]!=st[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int replace(char[] st, char[] tr, int p) {
        int count = 0;
        for(int i=0; i<st.length; i++) {
            if(tr[i+p]!='*') {
                tr[i+p] = '*';
                count++;
            }
        }
        return count;
    }
}