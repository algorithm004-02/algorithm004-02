package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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
public class LeetCode_127_537{

    public static void main(String[] args) {
         Solution solution = new LeetCode_127_537().new Solution();
        List<String> l = new ArrayList<String>();
        Collections.addAll(l, new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        solution.ladderLength("hit", "cog", l);
    }
    private 

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){

        //双向BFS  49ms
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        int count = 0;
        beginSet.add(beginWord);
        endSet.add(endWord);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        while (!beginSet.isEmpty()&&!endSet.isEmpty()){

            HashSet<String> temp;
            if (beginSet.size() > endSet.size()) {
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            temp = new HashSet<>();
            char[] word;
            char t;
            for (String str : beginSet) {
                if (endSet.contains(str)) {
                    return count+1;
                }
                word = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    t = str.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == t) {
                            continue;
                        }
                        word[i] = c;
                        if (wordSet.contains(String.valueOf(word))) {
                            temp.add(String.valueOf(word));
                        }
                    }
                    word[i] = t;
                }

            }
            count++;
            beginSet = temp;

        }


        //BFS 400ms
//        boolean[] visited = new boolean[wordList.size()];
//        Queue<String> queue = new LinkedBlockingQueue<>();
//        queue.offer(beginWord);
//        queue.offer("");
//        int count = 0;
//        while (!queue.isEmpty()) {
//            String str = queue.poll();
//            if (str.equals("")) {
//                if (queue.isEmpty()){
//                    break;
//                }
//                queue.offer("");
//                count++;
//                continue;
//            }
//            if (str.equals(endWord)) {
//                return count+1;
//            }
//            for (int i = 0; i < wordList.size(); i++) {
//                if (wordList.get(i).equals(beginWord)||visited[i]) {
//                    continue;
//                }
//                if (canTrans(str,wordList.get(i))) {
//                    queue.offer(wordList.get(i));
//                    visited[i] = true;
//                }
//            }
//        }
        return 0;
    }

        private boolean canTrans(String l, String s) {
            boolean b = false;
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) != s.charAt(i)) {
                    if (b) {
                        return false;
                    }else{
                        b = true;
                    }
                }
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}