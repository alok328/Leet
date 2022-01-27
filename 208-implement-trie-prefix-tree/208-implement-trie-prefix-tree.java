class TrieNode {
    boolean endsHere = false;
    TrieNode[] children = new TrieNode[26];
}

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(temp.children[idx]==null){
                temp.children[idx] = new TrieNode();
            }
            temp = temp.children[idx];
        }
        if(temp!=root)
            temp.endsHere = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(temp.children[idx]==null){
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.endsHere;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(temp.children[idx]==null){
                return false;
            }
            temp = temp.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */