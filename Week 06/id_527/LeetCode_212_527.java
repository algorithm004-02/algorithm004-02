/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    static class TrieNode {
        private static final int SIZE = 26;
        private TrieNode[] children;
        private boolean isEnd;
        String val;

        public TrieNode() {
            children = new TrieNode[SIZE];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public void setEnd(String val) {
            isEnd = true;
            this.val = val;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd(word);
        }

        public boolean find(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }
            return true;
        }
    }

    private Set<String> result = new HashSet();

    private static final int[][] dir = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

    private int rowLen;
    private int colLen;

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        rowLen = board.length;
        colLen = board[0].length;

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                find(board, i, j, trie.root, visited);
            }
        }

        return new LinkedList<String>(result);
    }

    private void find(char[][] board, int i, int j, TrieNode cur, boolean[][] visited) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || visited[i][j]) {
            return;
        }
        cur = cur.get(board[i][j]);
        if (cur == null) {
            return;
        }
        visited[i][j] = true;
        if (cur.isEnd()) {
            result.add(cur.val);
        }
        for (int[] d : dir) {
            find(board, i + d[0], j + d[1], cur, visited);
        }
        visited[i][j] = false;
    }
}
// @lc code=end
