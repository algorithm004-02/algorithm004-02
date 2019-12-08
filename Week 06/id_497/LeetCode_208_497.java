class Trie {

    class TrieNode{
        private TrieNode[] trieLinks;
        private int R = 26;
        private boolean isEnd;

        public TrieNode() {
            this.trieLinks = new TrieNode[R];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean containKey(char cha){
            return trieLinks[cha -'a']!=null;
        }

        public TrieNode get(char cha){
            return trieLinks[cha-'a'];
        }

        public void put(char cha, TrieNode node){
            trieLinks[cha-'a'] = node;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {

        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getWordNode(word);
        return node!=null&&node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = getWordNode(prefix);
        return node!=null;
    }
    public TrieNode getWordNode(String str){
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if(node.containKey(currentChar)){
                node =  node.get(currentChar);
            }else {
                return null;
            }
        }

        return node;
    }
}