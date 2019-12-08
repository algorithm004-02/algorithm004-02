package datastruct.dfsAndbfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 *
 *  给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 *  转换需遵循如下规则：

     每次转换只能改变一个字母。
     转换过程中的中间单词必须是字典中的单词。
     说明:

     如果不存在这样的转换序列，返回 0。
     所有单词具有相同的长度。
     所有单词只由小写字母组成。
     字典中不存在重复的单词。
     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

     输入:
     beginWord = "hit",
     endWord = "cog",
     wordList = ["hot","dot","dog","lot","log","cog"]
        输出: 5

     解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
     示例 2:

     输入:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log"]

     输出: 0
        解释: endWord "cog" 不在字典中，所以无法进行转换。



 *
 */
public class WordLadder {

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>();

        //"hot","dot","dog","lot","log","cog"
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 0;
        //int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0;i < chs.length; i++) {
                    for (char c = 'a';c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;

                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len ++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }


}
