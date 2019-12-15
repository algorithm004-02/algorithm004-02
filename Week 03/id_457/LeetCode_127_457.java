/**
 * 127. 单词接龙
 *  广度优先 BFS
 *  时间复杂度：O(M×N)，其中 M 是单词的长度, N 是单词表中单词的总数。
 *              找到所有的变换需要对每个单词做 M 次操作。
 *              同时，最坏情况下广度优先搜索也要访问所有的 N 个单词。
 *  空间复杂度：O(M×N)，要在字典中记录每个单词的 M 个通用状态。
 *              访问数组的大小是 N。广搜队列最坏情况下需要存储 N 个单词。
 */

import javafx.util.Pair;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();

        HashMap<String, ArrayList<String>> dict = new HashMap<String,ArrayList<String>>();

        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1,wordLength);
                ArrayList<String> transformations = dict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                dict.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord,true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i)+ '*' + word.substring(i+1, wordLength);
                for (String strWord : dict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (strWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(strWord)) {
                        visited.put(strWord, true);
                        queue.add(new Pair(strWord, level+1));
                    }
                }

            }
        }
        return 0;
    }
}