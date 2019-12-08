//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}

class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char curVal = word.charAt(i);
            if (ws.children[curVal - 'a'] == null) {
                ws.children[curVal - 'a'] = new TrieNode();
            }
            ws = ws.children[curVal - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char curVal = word.charAt(i);
            if (ws.children[curVal - 'a'] == null) return false;
            ws = ws.children[curVal - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curVal = prefix.charAt(i);
            if (ws.children[curVal - 'a'] == null) return false;
            ws = ws.children[curVal - 'a'];
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
//leetcode submit region end(Prohibit modification and deletion)
