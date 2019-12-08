package week6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/24 18:16
 * https://leetcode-cn.com/problems/word-search-ii/
 * 单词搜索2
 */
public class L212 {

  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    // 构造trie树，把单词记录在终止节点上，遍历到时不为空就找到一个单词了.
    TrieNode trieNode = buildTrieNode(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(board, i, j, trieNode, res);
      }
    }
    return res;
  }

  private void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> list) {
    char c = board[i][j];
    // 递归终止条件
    if (c == '#' || trieNode.get(c - 'a') == null) {
      return;
    }

    // 当前层处理逻辑
    trieNode = trieNode.get(c - 'a');
    if (trieNode.getWord() != null) {
      list.add(trieNode.getWord());
      System.out.println(trieNode.getWord());
      // 找到了就不再找了.
      trieNode.setWord(null);
    }
    // 访问过的，标记下，不再访问.
    board[i][j] = '#';

    // 下一层
    for (int k = 0; k < dx.length; k++) {
      int ii = i + dx[k];
      int jj = j + dy[k];
      // 深度优先和剪枝
      if (ii >= 0 && jj >= 0 && ii < board.length && jj < board[i].length) {
        dfs(board, ii, jj, trieNode, list);
      }
    }

    // 清除中间状态.
    board[i][j] = c;
  }

  TrieNode buildTrieNode(String[] words) {
    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; i++) {
      TrieNode trieNode = root;
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        char c = word.charAt(j);
        int index = c - 'a';
        if (trieNode.get(index) == null) {
          trieNode.set(index, new TrieNode());
        }
        trieNode = trieNode.get(index);
      }
      // 记录一个word，这是结尾.
      trieNode.setWord(word);
    }
    return root;
  }

  class TrieNode {

    private TrieNode[] trieNodes;

    private String word;

    public TrieNode() {
      trieNodes = new TrieNode[26];
    }


    public TrieNode get(int i) {
      return trieNodes[i];
    }

    public TrieNode set(int i, TrieNode node) {
      trieNodes[i] = node;
      return trieNodes[i];
    }

    public String getWord() {
      return word;
    }

    public void setWord(String word) {
      this.word = word;
    }
  }

  public static void main(String[] args) {
    L212 l212 = new L212();
    char[][] chars = {{'a', 'b'}, {'c', 'd'}};
    String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
    l212.findWords(chars, words);
  }
}


