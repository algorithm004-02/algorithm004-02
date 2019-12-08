package com.algorithm.qinchao.homework.week03;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/1 17:03
 * @description 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_127_202 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        if (!wordList.contains(endWord) || beginWord.length() != endWord.length()) {
            return count;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();
        queue.add(beginWord);
        visted.add(beginWord);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    return count + 1;
                }
                getNext(curr, wordList, queue, visted);
            }
            count++;
        }
        return 0;


    }

    private static void getNext(String curr, List<String> wordList, LinkedList<String> queue, Set<String> visted) {
        for (int i = wordList.size() - 1; i >= 0; i--) {
            int count = 0;
            String word = wordList.get(i);
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != curr.charAt(j)) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1 && !visted.contains(word)) {
                queue.add(word);
                visted.add(word);
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dog"});
        System.out.println(LeetCode_127_202.ladderLength(beginWord, endWord, wordList));
    }
}
