class LeetCode_208_487 {

    /**
     * 208
     * 实现 Trie (前缀树)
     *
     * @param grid
     * @return
     */
    class TrieNode {
        private TrieNode childs[];
        private Character value;
        private boolean isEnd = false;

        public TrieNode() {
            childs = new TrieNode[26];
        }

        public boolean containKey(char ch) {
            return childs[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return childs[ch - 'a'];
        }

        public void put(char ch) {
            if (childs[ch - 'a'] != null) return;
            childs[ch - 'a'] = new TrieNode();
            childs[ch - 'a'].value = ch;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //插入一个单词
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containKey(c)) {
                    node.put(c);
                }
                node = node.get(c); //当前节点设置成下一个节点
            }
            node.setEnd(true);//for循环结束，最后一个节点设置true
        }

        //判断存在前缀
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!node.containKey(c)) return false;
                node = node.get(c);
            }
            return true;
        }

        //搜索单词节点的最后一个节点
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.containKey(c)) node = node.get(c);
                else return null;
            }
            return node;
        }

        //判断是否存在改单词（结尾isEnd必须为true）
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            TrieNode trieNode = searchPrefix(word);
            return trieNode != null && trieNode.isEnd();
        }
    }
}