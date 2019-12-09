public class LeetCode_208_677 {
    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         * Trie obj = new Trie();
         * obj.insert(word);
         * boolean param_2 = obj.search(word);
         * boolean param_3 = obj.startsWith(prefix);
         */
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app"));       // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }
}

/**
 * 字典树、前缀树
 */
class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode node = root;
        for(char c : letters) {
            int index = c - 'a';
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new TrieNode();
            }
            node = node.getChildren()[index];
        }
        node.end();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] letters = word.toCharArray();
        TrieNode node = root;
        for (char c : letters) {
            int index = c - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return node.isWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        TrieNode node = root;
        for (char c : letters) {
            int index = c - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return true;
    }
}

class TrieNode {

    public static final int MAX = 26;

    private TrieNode[] children;

    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[MAX];
    }

    public void end() {
        this.isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode[] getChildren() {
        return children;
    }
}
