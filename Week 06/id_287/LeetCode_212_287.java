package com.tulane.leetcode.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_212 {


    /**
     * 定义单词存储set
     */
    private Set<String> set;

    /**
     * 定义字典树
     */
    private Trie trie;

    /**
     * 定义备忘录
     */
    private boolean[][] memo;

    /**
     * 定义向量
     */
    private int[] dx;
    private int[] dy;

    public List<String> findWords(char[][] board, String[] words) {
        /**
         * 初始化
         */
        set = new HashSet<>();
        trie = new Trie();
        memo = new boolean[board.length][];
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }
        for (String word : words) {
            trie.insert(word);
        }

        /**
         * dfs
         */
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                dfs(board, row, col, new StringBuilder(), trie);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int row, int col, StringBuilder strb, Trie trie) {
        // terminator
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || memo[row][col]) return;

        strb = strb.append(board[row][col]);
        memo[row][col] = true;

        // 剪枝
        if (trie.startsWith(strb.toString())) {

            if (trie.search(strb.toString())) {
                set.add(strb.toString());
            }

            //drill down
            for (int i = 0; i < dx.length; i++) {
                dfs(board, row + dx[i], col + dy[i], strb, trie);
            }
        }

        //状态清空
        strb.deleteCharAt(strb.length() - 1);
        memo[row][col] = false;
    }


    // --------- 基础 ------------------

    class TreeNode {
        private final int SIZE = 26;
        private TreeNode children[];
        private boolean isEnd = false;

        public TreeNode() {
            children = new TreeNode[SIZE];
        }

        // 判断是否存在对应字符
        public boolean containsKey(char key) {
            return children[key - 'a'] != null;
        }

        // 查询子树
        public TreeNode get(char key) {
            return children[key - 'a'];
        }

        // 插入子树
        public void put(char key, TreeNode sub) {
            children[key - 'a'] = sub;
        }

        // 设为结束点
        public void setEnd() {
            isEnd = true;
        }

        // 判断是否为结束节点
        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new TreeNode());
                }
                node = node.get(c); // 进入下一节点
            }
            node.setEnd(); // 设为结束点
        }

        // 抽象出查找前缀的公有方法
        private TreeNode searchPrefix(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    return null;
                }
                node = node.get(c);
            }
            return node;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode node = searchPrefix(word);
            return node != null && node.isEnd(); // 判断是否为结束点
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }


    }

}
