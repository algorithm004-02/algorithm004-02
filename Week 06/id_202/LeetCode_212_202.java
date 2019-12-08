package com.algorithm.qinchao.homework.week06;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 14:08
 * @description 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例:
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_212_202 {
    /**
     * 时间复杂度：O(N) = O(k*w）+O(M*N*4^k)
     *
     * @param board
     * @param words
     * @return
     */
    public static List<String> findWordsByDfs(char[][] board, String[] words) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Trie trie = new Trie();
        Set<String> result = new HashSet<>();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    recursive(i, j, board, trie, "", dx, dy, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static void recursive(int i, int j, char[][] board, Trie trie, String str, int[] dx, int[] dy, Set<String> result) {
        str += board[i][j];
        if (trie.startsWith(str)) {
            if (trie.search(str)) {
                result.add(str);
            }
            char temp = board[i][j];
            board[i][j] = '#';
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (0 <= x && x < board.length && 0 <= y && y < board[0].length && board[x][y] != '#') {
                    recursive(x, y, board, trie, str, dx, dy, result);
                }
            }
            board[i][j] = temp;
        }
    }


    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println(LeetCode_212_202.findWordsByDfs(board, words));
    }
}
