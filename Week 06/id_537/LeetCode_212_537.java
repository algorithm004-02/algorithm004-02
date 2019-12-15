package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
public class LeetCode_212_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_212_537().new Solution();
//        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"});
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        solution.findWords(board, new String[]{"acdb"});
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //        private HashMap<Character, ArrayList<TreeNode>> map1;
        private HashSet<String> set = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            ArrayList result = new ArrayList<>();
            //字典树 耗时24ms
            char c = 0;
            TreeNode head = new TreeNode(c);
            TreeNode temp;
            for (String word : words) {
                temp = head;
                for (int j = 0; j < word.length(); j++) {
                    c = word.charAt(j);
                    if (temp.links[c - 'a'] == null) {
                        temp.links[c - 'a'] = new TreeNode(c);
                    }
                    temp = temp.links[c - 'a'];
                    if (j == word.length() - 1) {
                        temp.isEnd = true;
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (head.links[board[i][j] - 'a'] != null) {
                        search(head.links[board[i][j] - 'a'], board, i, j, "");
                    }
                }
            }
            result = new ArrayList<String>();
            Collections.addAll(result, set.toArray());


            //暴力 耗时大约1000ms
//            TreeNode[][] trie = new TreeNode[board.length][board[0].length];
//            map1 = new HashMap<>(26);
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    trie[i][j] = new TreeNode(board[i][j],i,j);
//                    if (!map1.containsKey(board[i][j])) {
//                        map1.put(board[i][j], new ArrayList<>());
//                    }
//                    map1.get(board[i][j]).add(trie[i][j]);
//                }
//            }
//            HashMap<TreeNode, Integer> map = new HashMap<>(board.length * board[0].length);
//            for (int i = 0; i < words.length; i++) {
//                map.clear();
//                if (isContains(words[i], trie, map)) {
//                    result.add(words[i]);
//                }
//            }

            return result;
        }

        private void search(TreeNode node, char[][] board, int i, int j, String s) {
            if (node == null || board[i][j] == '@') {
                return;
            }
            s += node.val;
            if (node.isEnd) {
                set.add(s);
            }
            char c = board[i][j];
            board[i][j] = '@';
            if (i != 0 && board[i - 1][j] != '@') {
                search(node.links[board[i - 1][j] - 'a'], board, i - 1, j, s);
            }
            if (j != 0 && board[i][j - 1] != '@') {
                search(node.links[board[i][j - 1] - 'a'], board, i, j - 1, s);
            }
            if (i != board.length - 1 && board[i + 1][j] != '@') {
                search(node.links[board[i + 1][j] - 'a'], board, i + 1, j, s);
            }
            if (j != board[0].length - 1 && board[i][j + 1] != '@') {
                search(node.links[board[i][j + 1] - 'a'], board, i, j + 1, s);
            }
            board[i][j] = c;
        }

        private class TreeNode {
            char val;
            TreeNode[] links;
            boolean isEnd;

            TreeNode(char c) {
                val = c;
                links = new TreeNode[26];
            }
        }

//        private boolean isContains(String word, TreeNode[][] trie, HashMap<TreeNode, Integer> map) {
//            if (word == null || word.length() == 0) {
//                return false;
//            }
//            if (map1.containsKey(word.charAt(0))) {
//                ArrayList<TreeNode> treeNodes = map1.get(word.charAt(0));
//                for (int i = 0; i < treeNodes.size(); i++) {
//                    if (find(word,trie,map,0,treeNodes.get(i).i,treeNodes.get(i).j)){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }

//        private boolean find(String word, TreeNode[][] trie, HashMap<TreeNode, Integer> map, int index, int i, int j) {
//            if (map.containsKey(trie[i][j])) {
//                return false;
//            }
//            if (word.charAt(index) != trie[i][j].val) {
//                return false;
//            }
//            if (word.length() == index+1) {
//                return true;
//            }
//            map.put(trie[i][j], 0);
//            boolean b = (i != 0 && find(word, trie, map, index + 1, i - 1, j))
//                    || (i != trie.length - 1 && find(word, trie, map, index + 1, i + 1, j))
//                    || (j != 0 && find(word, trie, map, index + 1, i, j - 1))
//                    || (j != trie[0].length - 1 && find(word, trie, map, index + 1, i, j + 1));
//            map.remove(trie[i][j]);
//            return b;
//        }


//        private class TreeNode {
//            char val;
//            int i;
//            int j;
//            TreeNode(char val,int i ,int j) {
//                this.val = val;
//                this.i = i;
//                this.j = j;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}