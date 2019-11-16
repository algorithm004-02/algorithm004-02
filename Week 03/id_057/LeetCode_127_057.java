package app.homeworkWeekThird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (25.95%)
 * Likes:    1966
 * Dislikes: 930
 * Total Accepted:    317.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    public class Pair<T, V> {
        T key;
        V value;
        Pair(T key, V value) { 
            this.key = key;
            this.value = value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return ladderLength_bfs_bidirectional(beginWord, endWord, wordList);
    }



    /**
     * 通过双向查找相遇来降低时间复杂度，
     * 空间复杂度O(m * n) 
     * 时间复杂度O(m * n)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int ladderLength_bfs_bidirectional(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int wordLength = beginWord.length();
        Map<String, List<String>> dics = new HashMap<>();
        //convert wordList to map
        wordList.forEach(word -> {
            for (int i = 0; i < wordLength; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> dic = dics.getOrDefault(key, new ArrayList<>());
                dic.add(word);
                dics.put(key, dic);
            }
        });

        //queue for bfs
        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
        beginQueue.add(new Pair<String, Integer>(beginWord, 1));

        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
        endQueue.add(new Pair<String, Integer>(endWord, 1));

        //store visted words
        Map<String, Integer> beginQueueVistedWord = new HashMap<>();
        beginQueueVistedWord.put(beginWord, 1);

        Map<String, Integer> endQueueVistedWord = new HashMap<>();
        endQueueVistedWord.put(endWord, 1);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int steps = visitedWord(beginQueue, beginQueueVistedWord, endQueueVistedWord, dics, wordLength);
            if (steps > -1) {
                return steps;
            }

            steps = visitedWord(endQueue, endQueueVistedWord, beginQueueVistedWord, dics, wordLength);
            if (steps > -1) {
                return steps;
            }
        }
        return 0;
    }

    private int visitedWord(Queue<Pair<String, Integer>> queue, Map<String, Integer> selfVistedWord,
        Map<String, Integer> ohterVistedWord, Map<String, List<String>> dics, int wordLength) {
                Pair<String, Integer> pair = queue.poll();
                String word = pair.key;
                Integer step = pair.value;
                for (int i = 0; i < wordLength; i++) {
                    String key = word.substring(0, i) + "*" + word.substring(i + 1);
                    if (dics.containsKey(key)) {
                        for (String similarWord : dics.get(key)) {
                            if (ohterVistedWord.containsKey(similarWord)) {
                                return step + ohterVistedWord.getOrDefault(similarWord, 0);
                            }
                            if (!selfVistedWord.containsKey(similarWord)) {
                                selfVistedWord.put(similarWord,step + 1);
                                queue.add(new Pair<String, Integer>(similarWord, step + 1));
                            }
                        }
                    }
                }
                return -1;
    }

    /**
     * 把字典转换成所有可能的抽象结构，如：big映射成*ig、b*g、bi*和dig映射成*ig、d*g、di*； i*g(big，dig)，
     * b*g(big)，bi*(big), d*g(dig)，di*(dig)
     * 
     * 通过bfs遍历，注意不要行程环（检查是否已访问过） 时间复杂度O(m * n) 空间复杂度O(m * n)
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        Map<String, List<String>> dics = new HashMap<>();
        //convert wordList to map
        wordList.forEach(word -> {
            for (int i = 0; i < wordLength; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> dic = dics.getOrDefault(key, new ArrayList<>());
                dic.add(word);
                dics.put(key, dic);
            }
        });

        //queue for bfs
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));

        //store visted words
        Set<String> vistedWord = new HashSet<>();
        vistedWord.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.key;
            Integer step = pair.value;
            for (int i = 0; i < wordLength; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                if (dics.containsKey(key)) {
                    for (String similarWord : dics.get(key)) {
                        if (Objects.equals(similarWord, endWord)) {
                            return step + 1;
                        } else if (!vistedWord.contains(similarWord)) {
                            vistedWord.add(similarWord);
                            queue.add(new Pair<String, Integer>(similarWord, step + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.ladderLength("hot", "dog", Arrays.asList("hot","dog"));
    }

}
// @lc code=end

