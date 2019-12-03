
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode p = this.root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }
    public boolean search(String word) {
        TrieNode p = this.root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return p.isWord;
    }

    public boolean startWith(String word) {
        TrieNode p = this.root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }

    class TrieNode {

        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}
