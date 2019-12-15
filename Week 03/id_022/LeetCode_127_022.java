//[127]单词接龙
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import java.util.*;


public class WordLadder {

    private Map<String, List<String>> dict;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        makeDict(wordList, beginWord.length());

        Queue<Set<String>> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.add(Collections.singleton(beginWord));
        levelQueue.add(1);

        while (!queue.isEmpty()) {
            int n = levelQueue.remove();
            for (String word : queue.remove()) {
                Set<String> sub = similar(word);
                if (sub.contains(endWord)) {
                    return n + 1;
                }

                queue.add(sub);
                levelQueue.add(n + 1);
            }
        }

        return 0;
    }

    private void makeDict(List<String> words, int len) {
        dict = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < len; i++) {
                String mask = word.substring(0, i) + '*' + word.substring(i + 1, len);
                List<String> group = dict.getOrDefault(mask, new ArrayList<>());
                group.add(word);
                dict.put(mask, group);
            }
        }
    }

    private Set<String> similar(String word) {
        int len = word.length();
        Set<String> find = new HashSet<>();
        for (int i = 0; i < len; i++) {
            String mask = word.substring(0, i) + '*' + word.substring(i + 1, len);
            List<String> group = dict.remove(mask);
            if (group != null) {
                find.addAll(group);
            }
        }
        return find;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        int result;

        List<String> list1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        result = solution.ladderLength("hit", "cog", list1);
        System.out.println(result);
        if (result != 5) {
            throw new AssertionError("case1");
        }

        List<String> list2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        result = solution.ladderLength("hit", "cog", list2);
        System.out.println(result);
        if (result != 0) {
            throw new AssertionError("case2");
        }

        List<String> list3 = Arrays.asList(
                "miss", "dusk", "musk", "tusk", "diss", "disk", "sang", "ties", "muss");
        result = solution.ladderLength("kiss", "tusk", list3);
        System.out.println(result);
        if (result != 5) {
            throw new AssertionError("case3");
        }
    }
}