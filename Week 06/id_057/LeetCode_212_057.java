package app.homeworkWeekSixth;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (30.44%)
 * Likes:    1567
 * Dislikes: 84
 * Total Accepted:    145.9K
 * Total Submissions: 470.8K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        return findWords_trie(board, words);
    }

    /**
     * Building trie with words
     * search board with dfs
     * @param board
     * @param words
     * @return
     */
    private List<String> findWords_trie(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>(words.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs_search(i, j, board, root, result);
            }
        }
        return result;
    }

    /**
     * 
     * @param i
     * @param j
     * @param board
     * @param root
     * @param result
     */
    private void dfs_search(int i, int j, char[][] board, TrieNode root, List<String> result) {
        //terminal condition
        char val = board[i][j];
        if (val == '#' || root.links[val - 'a'] == null) return;
        root = root.links[val - 'a'];

        //process
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';

        //drill down
        if (i > 0) dfs_search(i - 1, j, board, root, result);
        if (i < board.length - 1) dfs_search(i + 1, j, board, root, result);
        if (j > 0) dfs_search(i, j - 1, board, root, result);
        if (j < board[0].length - 1) dfs_search(i, j + 1, board, root, result);
        
        //reverse status
        board[i][j] = val;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode subRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char subChar = word.charAt(i);
                if (subRoot.links[subChar - 'a'] == null) {
                    subRoot.links[subChar - 'a'] = new TrieNode();
                }
                subRoot = subRoot.links[subChar - 'a'];
            }
            subRoot.word = word;
        }
        return root;
    }

    public class TrieNode {
        public TrieNode [] links;
        public String word;

        public TrieNode() {
            links = new TrieNode[26];
        }
    }
}
// @lc code=end

