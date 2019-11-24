package src.main.java.com.fans.algorithm00402.week6.homework;

import java.util.*;

/**
 * 单词搜索2
 */
public class LeetCode_212_232 {

    /**
     * DFS
     */
//    public List<String> findWords(char[][] board, String[] words) {
//        Set<String> ans = new HashSet<>();
//        Set<Integer> cache = new HashSet<>();
//        for (String word : words) {
//            for (int i = 0; i < board.length; i ++) {
//                for (int j = 0; j < board[i].length; j ++) {
//                    if (board[i][j] == word.charAt(0)) {
//                        dfs(ans, word, board, i, j, 0, cache);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(ans);
//    }
//
//    private void dfs(Set<String> ans, String word, char[][] board, int i, int j, int level, Set<Integer> cache) {
//        if (level == word.length() - 1 && board[i][j] == word.charAt(level)) {
//            ans.add(word);
//            return;
//        }
//
//        if (level == word.length() - 1) return;
//
//        cache.add(index(i, j, board));
//        if (board[i][j] == word.charAt(level)) {
//            if (j - 1 >= 0 && !cache.contains(index(i, j - 1, board))) dfs(ans, word, board, i, j - 1, level + 1, cache);
//            if (i - 1 >= 0 && !cache.contains(index(i - 1, j, board))) dfs(ans, word, board, i - 1, j, level + 1, cache);
//            if (j + 1 < board[0].length && !cache.contains(index(i, j + 1, board))) dfs(ans, word, board, i, j + 1, level + 1, cache);
//            if (i + 1 < board.length && !cache.contains(index(i + 1, j, board))) dfs(ans, word, board, i + 1, j, level + 1, cache);
//        }
//        cache.remove(index(i, j, board));
//    }
//
//    private int index(int i, int j, char[][] board) {
//        int m = board[0].length;
//        return i * m + j;
//    }


    /**
     * DFS + 回溯 + Trie剪枝
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] cache = new boolean[n][m];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (trie.startsWith(board[i][j] + "")) {
                    dfs(ans, board, i, j, "", cache, trie.root);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(Set<String> ans, char[][] board, int i, int j, String s, boolean[][] cache, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || cache[i][j])
            return;

        node = node.list[board[i][j] - 'a'];
        // 没有匹配上
        if (node == null) return;
        cache[i][j] = true;
        s += board[i][j];
        // 如果是单次结尾，就加入
        if (node.isEnd()) ans.add(s);
        dfs(ans, board, i, j - 1, s, cache, node);
        dfs(ans, board, i - 1, j, s, cache, node);
        dfs(ans, board, i, j + 1, s, cache, node);
        dfs(ans, board, i + 1, j, s, cache, node);

        cache[i][j] = false;
    }

    private class TrieNode {
        private boolean isEnd;

        private TrieNode[] list;

        public TrieNode() {
            list = new TrieNode[26];
        }

        public boolean containerKey(char ch) {
            return list[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return list[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            list[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    private class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word.length() == 0) return;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i ++) {
                if (!node.containerKey(chars[i])) {
                    node.put(chars[i], new TrieNode());
                }
                node = node.get(chars[i]);
            }
            node.isEnd = true;
        }

        private TrieNode searchPrefix(String word) {
            if (word.length() == 0) return null;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char ch : chars) {
                if (node.containerKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
