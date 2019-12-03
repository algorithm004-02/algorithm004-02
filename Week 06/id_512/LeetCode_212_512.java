package WEEK5.LeetCode.Trie;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * No.212
 *给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *示例:
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
 *
 *
* */
public class WordSearchII_212 {

        public class TrieNode{
            public boolean isWord = false;
            public TrieNode[] child = new TrieNode[26];
            public TrieNode(){

            }
        }

        TrieNode root = new TrieNode();
        boolean[][] flag;
        public List<String> findWords(char[][] board, String[] words) {
            Set<String> result = new HashSet<>();
            flag = new boolean[board.length][board[0].length];

            addToTrie(words);

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(root.child[board[i][j] - 'a'] != null){
                        search(board, i, j, root, "", result);
                    }
                }
            }

            return new LinkedList<>(result);
        }

        private void addToTrie(String[] words){
            for(String word: words){
                TrieNode node = root;
                for(int i = 0; i < word.length(); i++){
                    char ch = word.charAt(i);
                    if(node.child[ch - 'a'] == null){
                        node.child[ch - 'a'] = new TrieNode();
                    }
                    node = node.child[ch - 'a'];
                }
                node.isWord = true;
            }
        }

        private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
            if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]){
                return;
            }

            if(node.child[board[i][j] - 'a'] == null){
                return;
            }

            flag[i][j] = true;
            node = node.child[board[i][j] - 'a'];
            if(node.isWord){
                result.add(word + board[i][j]);
            }

            search(board, i-1, j, node, word + board[i][j], result);
            search(board, i+1, j, node, word + board[i][j], result);
            search(board, i, j-1, node, word + board[i][j], result);
            search(board, i, j+1, node, word + board[i][j], result);

            flag[i][j] = false;
        }

}
