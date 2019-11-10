package week3.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/28 23:08
 */
public class L433 {
  /**
   * https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
   * 最小基因变化，类似问题，最少几步，是不是都可以广度优先遍历呢?
   *
   * */
  public int minMutation(String start, String end, String[] bank) {
    if (start.equals(end)) {
      return 0;
    }
    if (bank.length == 0) {
      return -1;
    }
    char[] charList = {'A', 'C', 'G', 'T'};
    Set<String> visitedSet = new HashSet<>();
    Set<String> bankSet = new HashSet<>();
    for (int i = 0; i < bank.length; i++) {
      bankSet.add(bank[i]);
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    visitedSet.add(start);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        /**
         * 遍历这一层，这一层就是start变换一次所有可能的节点，并且在bank中的.
         * start.length * charList.length 这么多种变化的可能.
         * */
        String str = queue.poll();
        if (str.equals(end)) {
          return level;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
          char oldChar = chars[i];
          for (int j = 0; j < charList.length; j++) {
            chars[i] = charList[j];
            String newStr = new String(chars);
            if (!visitedSet.contains(newStr) && bankSet.contains(newStr)) {
              queue.offer(newStr);
              visitedSet.add(newStr);
            }
            chars[i] = oldChar;
          }
        }
      }
      level++;
    }
    return -1;
  }


  public static void main(String[] args) {
    String start = "AACCTTGG";
    String end = "AATTCCGG";
    String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
    L433 l433 = new L433();
    System.out.println(l433.minMutation(start, end, bank));
  }
}
