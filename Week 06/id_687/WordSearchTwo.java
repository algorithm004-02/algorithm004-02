package com.itliusir.trie;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * @author liugang
 * @date 2019-11-24
 */
public class WordSearchTwo {

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board =
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };
        List<String> result = new WordSearchTwo().findWords(board, words);
        result.forEach(res -> System.out.println(res));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                doFindWords(board, i, j, root, result);
            }
        }
        return result;
    }

    private void doFindWords(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j];
        // terminator
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        // process
        root = root.next[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        // drill down
        if (i > 0) {
            doFindWords(board, i - 1, j, root, result);
        }
        if (j > 0) {
            doFindWords(board, i, j - 1, root, result);
        }
        if (i < board.length - 1) {
            doFindWords(board, i + 1, j, root, result);
        }
        if (j < board[0].length - 1) {
            doFindWords(board, i, j + 1, root, result);
        }
        // reverse cur status
        board[i][j] = c;
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }

    class TrieNode {
        private final int R = 26;
        TrieNode[] next = new TrieNode[R];
        String word;
    }

}
