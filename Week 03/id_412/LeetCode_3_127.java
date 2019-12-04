package Week03.Chapter09;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_3_127 {
    // https://leetcode-cn.com/problems/word-ladder/description/

    // BFS
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 预处理
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // newWor -- d*g
                        String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                        // 有key返回 ArrayList<String> 类型的值  没有可以则返回新建的的 ArrayList<String>
                        ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        // 遍历每个单词的每个字符 用*代替  将代替后的单词作为key值 代替前的单词作为这个key的值存入
                        allComboDict.put(newWord, transformations);
                    }
                }
        );

//        System.out.println(allComboDict);
        //  do*=[dot, dog]
        //                          dot
        //          *ot             d*t           do*
        //      [hot,dot,lot]     [dot]        [dot,dog]
        //  深度优先--> 沿着dot往下走,起始是一个元素,直到遇见目标元素
        //  广度优先--> dot往外一次,dog往外一次,因此循环到遇到目标元素
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visitedWord = new HashMap<>();
        HashMap<String, Boolean> visitedPattern = new HashMap<>();
        visitedWord.put(beginWord, true);
        int outerLoopCount = 0;
        while (!Q.isEmpty()) {
            outerLoopCount++;
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            Integer level = node.getValue();
            // 第一个for 拿到单词的所有通用状态:三个通用状态  第二个for遍历这些通用状态可以匹配的所有单词
            // Q 存放没有进行过通用状态加工的单词
            // visitedWord 存放已经进行过通用状态加工的单词
//            System.out.printf("------------Outer Loop:%d-----------\n", outerLoopCount);
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                if (!visitedPattern.containsKey(newWord)) {
                    int innerLoopCount = 0;
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                        innerLoopCount++;
//                        System.out.printf("------------Inner Loop:%d-----------\n", innerLoopCount);
//                        System.out.printf("newWord：%s--adjacentWord：%s--allComboDict：%s\n", newWord, adjacentWord, allComboDict.getOrDefault(newWord, new ArrayList<>()));
                        if (adjacentWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (!visitedWord.containsKey(adjacentWord)) {
                            visitedWord.put(adjacentWord, true);
                            Q.add(new Pair(adjacentWord, level + 1));
//                            System.out.printf("visitedWord:%s--Q:%s\n", visitedWord, Q);
                        }
                    }
                    visitedPattern.put(newWord, true);
                }
            }
        }
        return 0;
    }

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
        LeetCode_3_127 test = new LeetCode_3_127();
        System.out.printf("%d\n", test.ladderLength(beginWord, endWord, wordList));
    }
}
