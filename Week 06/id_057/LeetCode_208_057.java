package app.homeworkWeekSixth;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (41.26%)
 * Likes:    2063
 * Dislikes: 36
 * Total Accepted:    219.4K
 * Total Submissions: 521.4K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */

// @lc code=start
class Trie {

    private TrieNode root;

    public class TrieNode {
        private TrieNode [] links;
        private final int linkSize = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode [linkSize];
        }

        public boolean containsChar(char a) {
            return links[a - 'a'] == null ? false : true;
        }

        public TrieNode getCharLink(char a) {
            return links[a - 'a'];
        }

        public void putCharLink(char a , TrieNode trie){ 
            links[a - 'a'] = trie;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode root = this.root;
        for (int i = 0; i < word.length(); i++) {
            char subChar = word.charAt(i);
            if (!root.containsChar(subChar)) {
                root.putCharLink(subChar, new TrieNode());
            }
            root = root.getCharLink(subChar);
        }
        root.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode root = this.root;
        for (int i = 0; i < word.length(); i++) {
            char subChar = word.charAt(i);
            if (!root.containsChar(subChar)) {
                return false;
            }
            root = root.getCharLink(subChar);
        }
        return root != null && root.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode root = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char subChar = prefix.charAt(i);
            if (!root.containsChar(subChar)) {
                return false;
            }
            root = root.getCharLink(subChar);
        }
        return root != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

