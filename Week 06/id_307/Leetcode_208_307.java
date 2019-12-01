class Trie {
    private static final int NODE_COUNT = 26;
    private class TrieNode {
        private TrieNode[] nodes = new TrieNode[NODE_COUNT];
        private boolean entireWord;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (current.nodes[pos] == null) {
                current.nodes[pos] = new TrieNode();
            }
            current = current.nodes[pos];
        }
        current.entireWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (current.nodes[pos] == null) {
                return false;
            }
            current = current.nodes[pos];
        }
        return current.entireWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (current.nodes[pos] == null) {
                return false;
            }
            current = current.nodes[pos];
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