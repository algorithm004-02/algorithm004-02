package week3.work;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/29 19:01
 * https://cloud.tencent.com/developer/article/1494313
 */
public class L127 {
  /**
   * BFS
   * */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> visitedSet = new HashSet<>();
    Set<String> wordSet = new HashSet<>();
    for (int i = 0; i < wordList.size(); i++) {
      wordSet.add(wordList.get(i));
    }
    int level = 1;
    int a = (int)'a';
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    visitedSet.add(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        // 处理一层
        String str = queue.poll();
        if (str.equals(endWord)) {
          return level;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
          char oldChar = chars[i];
          for (int j = 0; j <= 26; j++) {
            chars[i] = (char)(a + j);
            String newStr = new String(chars);
            if (!visitedSet.contains(newStr) && wordSet.contains(newStr)) {
              queue.offer(newStr);
              visitedSet.add(newStr);
            }
            chars[i] = oldChar;
          }
        }
      }
      level++;
    }
    return 0;
  }
}
