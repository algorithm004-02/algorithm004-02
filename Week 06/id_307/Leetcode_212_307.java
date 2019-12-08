class Solution {
    private static final int[] dx = new int[] {-1, 1, 0, 0};
    private static final int[] dy = new int[] {0, 0, -1, 1};
    private Trie trie;
    private HashSet<String> result;
    public void findExsitsWordByDfs(char[][] board, int x, int y, String prefix) {
        // terminator
        if (!trie.startsWith(prefix)) {
            return;
        }
        if (trie.search(prefix)) {
            result.add(prefix);
        }
        
        // process
        // travel directions
        int tx, ty;
        for (int i = 0; i < dx.length; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if (tx > -1 && tx < board[0].length && ty > -1 && ty < board.length && board[ty][tx] != '-') {
                char original = board[ty][tx];
                board[ty][tx] = '-';
                // drill down
                findExsitsWordByDfs(board, tx, ty, prefix + original);
                board[ty][tx] = original;
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        // init
        trie = new Trie();
        result = new HashSet<>();

        for (String word : words) {
            trie.insert(word);
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char original = board[i][j];
                board[i][j] = '-';
                findExsitsWordByDfs(board, j, i, "" + original);
                board[i][j] = original;
            }
        }

        return new ArrayList<>(result);
    }

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
}