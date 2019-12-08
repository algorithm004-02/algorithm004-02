
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_212_677 {

    private Trie root = new Trie();

    private boolean[][] visited;

    private Set<String> ans = new HashSet<>();

    int[] xx = new int[] {-1, 1, 0, 0};
    int[] yy = new int[] {0, 0, -1, 1};

    void buildTrie(String[] words) {
        for (String word : words) {
            root.insert(word);
        }
    }

    List<String> search(char[][] board) {
        ans.clear();
        visited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                dfs(0, board, "", x, y);
            }
        }
        return new ArrayList<>(ans);
    }

    void dfs(int level, char[][] board, String prefix, int x, int y) {
        // terminator
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || visited[x][y]) {
            return;
        }
        prefix += board[x][y];
        if (!root.startsWith(prefix)) {
            return;
        }

        // process current logic
        visited[x][y] = true;
        if (root.search(prefix)) {
            ans.add(prefix);
        }

        // drill down
        for (int i = 0; i < 4; i++) {
            int nx = x + xx[i], ny = y + yy[i];
            dfs(level + 1, board, prefix, nx, ny);
        }

        // revert state
        visited[x][y] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null|| board.length == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }
        buildTrie(words);
        return search(board);
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

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[] {"oath","pea","eat","rain"};
        LeetCode_212_677 s = new LeetCode_212_677();
        System.out.println(s.findWords(board, words));

        board = new char[][] {{'a','b'},{'c','d'}};
        words = new String[] {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        s = new LeetCode_212_677();
        System.out.println(s.findWords(board, words));
    }
}
