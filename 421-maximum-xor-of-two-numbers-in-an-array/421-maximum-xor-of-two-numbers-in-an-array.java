class Trie {
    Trie[] children;
    
    Trie(){
        this.children = new Trie[2];
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int n : nums){
            Trie  temp = trie;
            for(int i=31; i>=0; i--){
                int bit = (n>>i)&1;
                if(temp.children[bit]==null){
                    temp.children[bit] = new Trie();
                }
                temp = temp.children[bit];
            }
        }
        int maxXor = -1;
        for(int n : nums){
            Trie temp = trie;
            int num = 0;
            for(int i=31; i>=0; i--){
                int bit = (n>>i)&1;
                if(temp.children[bit^1]!=null){
                    num += (bit^1)<<i;
                    temp = temp.children[bit^1];
                }else{
                    num += bit<<i;
                    temp = temp.children[bit];
                }
            }
            maxXor = Math.max(maxXor, num^n);
        }
        return maxXor;
    }
}