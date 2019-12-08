package week6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/24 15:48
 * https://leetcode-cn.com/problems/word-ladder/
 * 单词接龙问题
 */
public class L127 {
  /**
   * 1、先用BFS实现
   * */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int len = 0;
    Queue<String> queue = new LinkedList<>();
    // 转成set，方便判断
    Set<String> wordSet = new HashSet<>(wordList);
    // 记录visited
    Set<String> visitedSet = new HashSet<>();
    queue.offer(beginWord);
    visitedSet.add(beginWord);
    if (!wordSet.contains(endWord)) {
      return len;
    }
    while (!queue.isEmpty()) {
      len++;
      int size = queue.size();
      while (size-- > 0) {
        String str = queue.poll();
        // 找到最小距离，返回len
        if (endWord.equals(str)) {
          return len;
        }
        // 广度优先遍历，一个一个字符尝试转换，找到它可以转换的在wordList中的单词
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
          char oldChar = chars[i];
          for (char c = 'a'; c <= 'z'; c++) {
            chars[i] = c;
            String newString = String.valueOf(chars);
            if (!visitedSet.contains(newString) && wordSet.contains(newString)) {
              queue.offer(newString);
              visitedSet.add(newString);
            }
            chars[i] = oldChar;
          }
        }
      }
    }
    return 0;
  }

  /**
   * 双向BFS.
   * */
  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Set<String> beginSet = new HashSet<>();
    beginSet.add(beginWord);
    Set<String> endSet = new HashSet<>();
    endSet.add(endWord);
    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> vistedSet = new HashSet<>();
    int len = 1;
    /**
     * 这要判断下，如果wordList不包含end就结束，否则如果不包含也能转成.
     * */
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      len++;
      // 交换
      if (beginSet.size() > endSet.size()) {
        Set<String> tmp = endSet;
        endSet = beginSet;
        beginSet = tmp;
      }
      Set<String> tempSet = new HashSet<>();
      for (String str : beginSet) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
          char oldChar = chars[i];
          for (char c = 'a'; c <= 'z' ; c++) {
            chars[i] = c;
            String newString = String.valueOf(chars);
            // 终止条件是他们访问到同一个点
            if (endSet.contains(newString)) {
              return len;
            }

            if (!vistedSet.contains(newString) && wordSet.contains(newString)) {
              tempSet.add(newString);
              vistedSet.add(newString);
            }
            chars[i] = oldChar;
          }
        }
      }
      beginSet = tempSet;
    }
    return 0;
  }

  public static void main(String[] args) {
    L127 l127 = new L127();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
    int i = l127.ladderLength2(beginWord, endWord, wordList);
    System.out.println(i);
  }
}
