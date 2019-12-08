package com.algorithm.qinchao.homework.week06;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/21 15:34
 * @description 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
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
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_127_202 {
    private int result = 0;
    public int ladderLengthByBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();
        queue.add(beginWord);
        visted.add(beginWord);
        int result = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    return result + 1;
                }
                getNext(curr, visted, queue, wordSet);
            }
            result++;
        }
        return 0;
    }

    private void getNext(String curr, Set<String> visted, LinkedList<String> queue, Set<String> wordSet) {
        char[] chars = curr.toCharArray();
        for (int i = 0; i < curr.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char temp = chars[i];
                chars[i] = ch;
                String s = String.valueOf(chars);
                if (!visted.contains(s) && wordSet.contains(s)) {
                    queue.add(s);
                    visted.add(s);
                }
                chars[i] = temp;
            }
        }
    }

    public int ladderLengthByDoubleBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int result = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visted = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visted.add(beginWord);
        visted.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> exchange = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char temp = chars[i];
                        chars[i] = ch;
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) {
                            return result + 1;
                        }
                        if (!visted.contains(target) && wordSet.contains(target)) {
                            exchange.add(target);
                            visted.add(target);
                        }
                        chars[i] = temp;
                    }
                }
            }
            beginSet = exchange;
            result++;
        }
        return 0;
    }
//
//    public int ladderLengthByDoubleDFS(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> visted = new HashSet<>();
//        if (!wordSet.contains(endWord)) {
//            return 0;
//        }
//        visted.add(beginWord);
//        recursive(0, endWord, beginWord, wordSet, visted);
//        return result - 1;
//    }
//
//    private int recursive(Integer level, String endWord, String beginWord, Set<String> wordSet, Set<String> visted) {
//        if (beginWord.equals(endWord)) {
//            return result;
//        }
//        char[] chars = beginWord.toCharArray();
//        for (int i = 0; i < beginWord.length(); i++) {
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                char temp = chars[i];
//                chars[i] = ch;
//                String s = String.valueOf(chars);
//                if (!visted.contains(s) && wordSet.contains(s)) {
//                    visted.add(s);
//                    wordSet.remove(s);
//                    result++;
//                    recursive(level + 1, endWord, s, wordSet, visted);
//                }
//                chars[i] = temp;
//
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_127_202().ladderLengthByBFS(
                "hit", "cog",
                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
        System.out.println(new LeetCode_127_202().ladderLengthByDoubleBFS(
                "hit", "cog",
                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
//        System.out.println(new LeetCode_127_202().ladderLengthByDoubleDFS(
//                "hit", "cog",
//                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
}
