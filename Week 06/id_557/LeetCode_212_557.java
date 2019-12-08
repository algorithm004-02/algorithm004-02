package leetcode.editor.cn;
//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}

class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char curVal = word.charAt(i);
            if (ws.children[curVal - 'a'] == null) {
                ws.children[curVal - 'a'] = new TrieNode();
            }
            ws = ws.children[curVal - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char curVal = word.charAt(i);
            if (ws.children[curVal - 'a'] == null) return false;
            ws = ws.children[curVal - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curVal = prefix.charAt(i);
            if (ws.children[curVal - 'a'] == null) return false;
            ws = ws.children[curVal - 'a'];
        }
        return true;
    }
}

class Solution {
    //定义方向坐标
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};
    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || words.length == 0) return new ArrayList<String>();
        //建立字典树
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        List<String> result = new ArrayList<>();
        //dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, "", result, board);
            }
        }
        return result;
    }

    private void dfs(int row, int col, String curStr, List<String> result, char[][] board) {
        char restore = board[row][col];
        String newStr = curStr + restore;

        if (trie.search(newStr) && result.indexOf(newStr) == -1) {
            result.add(newStr);
        }
        if (!trie.startsWith(newStr)) return;
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            int tempx = x[i] + row;
            int tempy = y[i] + col;
            if (tempx >= 0 && tempx < board.length && tempy >= 0 && tempy < board[0].length && board[tempx][tempy] != '#') {
                dfs(tempx, tempy, newStr, result, board);
            }
        }
        board[row][col] = restore;
    }

    public static void main(String[] args) {
        char[][] board={{'a'}};
        String[] words={"a"};
        List<String> words1 = new Solution().findWords(board, words);
        System.out.println(words1);
    }
}



//leetcode submit region end(Prohibit modification and deletion)
