package com.itliusir.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * problem.127
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 *
 * @author liugang
 * @date 2019-11-03
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new WordLadder().ladderLengthTwo(beginWord, endWord, wordList));
    }


    /**
     * method 1 -> time O(wordSize * wordListSize) space O(wordSize * wordListSize)
     * <p>
     * BFS
     *
     * @author liugang
     * @date 2019-11-03 19:23:40
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordSize = beginWord.length();

        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < wordSize; i++) {
                        String abstractWord = word.substring(0, i) + "*" +
                                word.substring(i + 1, wordSize);
                        ArrayList<String> transformations = allComboDict.getOrDefault(abstractWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(abstractWord, transformations);
                    }
                }
        );

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < wordSize; i++) {
                String abstractWord = word.substring(0, i) + "*" +
                        word.substring(i + 1, wordSize);

                for (String likeAbstractWord : allComboDict.getOrDefault(abstractWord, new ArrayList<>())) {
                    if (likeAbstractWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(likeAbstractWord)) {
                        visited.add(likeAbstractWord);
                        queue.add(new Pair<>(likeAbstractWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * method 2 -> time O(wordSize * wordListSize) space O(wordSize * wordListSize)
     *
     * DFS
     *
     * @author liugang
     * @date 2019-11-03 21:35:57
     */
    public int ladderLengthTwo(String beginWord, String endWord, List<String> wordList) {
        Set<String> remainWordList = new HashSet<>(wordList);
        if (!remainWordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        return doLadderLength(beginSet, endSet, remainWordList, 1);
    }

    private int doLadderLength(Set<String> beginSet, Set<String> endSet, Set<String> remainWordList, int cnt) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return 0;
        cnt++;
        remainWordList.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for (String str : beginSet) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chs[i] = j;
                    String tmp = new String(chs);
                    if (!remainWordList.contains(tmp)) continue;
                    if (endSet.contains(tmp)) return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size() > endSet.size() ? doLadderLength(endSet, nextSet, remainWordList, cnt) : doLadderLength(nextSet, endSet, remainWordList, cnt);
    }
}
