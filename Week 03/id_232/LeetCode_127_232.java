package src.main.java.com.fans.algorithm00402.week3.homework;

import java.security.KeyPair;
import java.util.*;

/**
 * 单词接龙
 */
public class LeetCode_127_232 {
    /**
     * 1. DFS + 回溯 time limit
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        HashMap<String, Boolean> used = new HashMap<>();
//        int count = dfs(beginWord, endWord, wordList, 1, used);
//        return count == -1 ? 0 : count;
//    }
//
//    private int dfs(String beginWord, String endWord, List<String> wordList, int level, HashMap<String, Boolean> used) {
//
//        // terminator
//        if (beginWord.equals(endWord))
//            return level;
//        // process
//        int resLevel = -1;
//        for (int i = 0; i < wordList.size(); i ++) {
//            if (used.get(wordList.get(i)) == null && isCan(beginWord, wordList.get(i))) {
//                used.put(wordList.get(i), true);
//                int temp = dfs(wordList.get(i), endWord, wordList, level + 1, used);
//                used.remove(wordList.get(i));
//                if (temp != -1) {
//                    if (resLevel == -1) resLevel = temp;
//                    else resLevel = Math.min(temp, resLevel);
//                }
//            }
//        }
//
//        return resLevel;
//    }

    /**
     * 2. BFS (O(n^2),O(n))
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> queue = new LinkedList<>();
//        if (beginWord != null) queue.add(beginWord);
//        HashMap<String, Boolean> used = new HashMap<>();
//
//        int level = 1;
//        while (!queue.isEmpty()) {
//            level ++;
//            int size = queue.size();
//            while (size -- > 0) {
//                beginWord = queue.poll();
//                for (int i = 0; i < wordList.size(); i ++) {
//                    if (!used.containsKey(wordList.get(i)) && isCan(beginWord, wordList.get(i))) {
//                        if (wordList.get(i).equals(endWord)) return level;
//                        queue.add(wordList.get(i));
//                        used.put(wordList.get(i), true);
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    private Boolean isCan(String str, String otherStr) {
//        char[] chars = str.toCharArray();
//        char[] otherChars = otherStr.toCharArray();
//
//        int res = 0;
//        for (int i = 0; i < chars.length; i ++) {
//            if (chars[i] != otherChars[i]) res ++;
//        }
//        return res == 1;
//    }

    /**
     * 3. BFS 优化
     *  突破点
     *  - 每次都要进行遍历查找下一级节点
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> queue = new LinkedList<>();
//        if (beginWord != null) queue.add(beginWord);
//        HashMap<String, Boolean> used = new HashMap<>();
//        // 构建map去缓存处理好的wordlist
//        HashMap<String, List<String>> allComboDict = new HashMap<String, List<String>>();
//
//        for (int i = 0; i < wordList.size(); i ++) {
//            String word = wordList.get(i);
//            for (int j = 0; j < word.length(); j ++) {
//                String key = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
//                if (allComboDict.containsKey(key)) {
//                    List<String> temp = allComboDict.get(key);
//                    temp.add(word);
//                } else {
//                    List<String> temp = new ArrayList<>();
//                    temp.add(word);
//                    allComboDict.put(key, temp);
//                }
//            }
//        }
//
//        int level = 1;
//        while (!queue.isEmpty()) {
//            level ++;
//            int size = queue.size();
//            while (size -- > 0) {
//                beginWord = queue.poll();
//                for (int j = 0; j < beginWord.length(); j ++) {
//                    String key = beginWord.substring(0, j) + "*" + beginWord.substring(j + 1, beginWord.length());
//                    if (allComboDict.containsKey(key)) {
//                        for (int i = 0; i < allComboDict.get(key).size(); i ++) {
//                            if (!used.containsKey(allComboDict.get(key).get(i))) {
//                                if (allComboDict.get(key).get(i).equals(endWord)) return level;
//                                queue.add(allComboDict.get(key).get(i));
//                                used.put(allComboDict.get(key).get(i), true);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    /**
     * 4. 双向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        if (beginWord.length() == 1) return 2;
        // 构建map去缓存处理好的wordlist
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        for (int i = 0; i < wordList.size(); i ++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j ++) {
                String key = word.substring(0, j) + "*" + word.substring(j + 1);
                if (allComboDict.containsKey(key)) {
                    List<String> temp = allComboDict.get(key);
                    temp.add(word);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(word);
                    allComboDict.put(key, temp);
                }
            }
        }

        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        HashMap<String, Boolean> beginUsed = new HashMap<>();
        HashMap<String, Boolean> endUsed = new HashMap<>();

        if (beginWord != null) {
            beginQueue.add(beginWord);
            beginUsed.put(beginWord, true);
        }
        if (endWord != null) {
            endQueue.add(endWord);
            endUsed.put(endWord, true);
        }

        String begin = beginWord;
        String end = endWord;

        int level = 0;

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {

            if (beginQueue.size() > endQueue.size()) {
                Queue temp = endQueue;
                endQueue = beginQueue;
                beginQueue = temp;

                HashMap used = beginUsed;
                beginUsed = endUsed;
                endUsed = used;
            }

            int beginSize = beginQueue.size();
            level ++;
            while (beginSize -- > 0) {
                begin = beginQueue.poll();

                for (int i = 0; i < begin.length(); i ++) {
                    String key = begin.substring(0, i) + "*" + begin.substring(i + 1);
                    if (allComboDict.containsKey(key)) {
                        for (int j = 0; j < allComboDict.get(key).size(); j ++) {
                            if (beginUsed.containsKey(allComboDict.get(key).get(j))) continue;
                            beginUsed.put(allComboDict.get(key).get(j), true);
                            if (endUsed.containsKey(allComboDict.get(key).get(j))) return level + 1;
                            beginQueue.add(allComboDict.get(key).get(j));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_127_232 code = new LeetCode_127_232();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(code.ladderLength("hit", "cog", list));
    }
}
