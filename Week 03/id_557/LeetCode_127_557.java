//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// 
//
// 
// 
// Related Topics Breadth-first Search


import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //思路，使用双端BFS，从首尾分别开始BFS,由于BFS越往下分支越多，所以采用双端可以减少分支数，从而节省时间
        if (!wordList.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> dicSet = new HashSet<>(wordList);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //从短的一端开始搜索
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for (String word :
                    beginSet) {
                char[] chars = word.toCharArray();
                //查找所有可能生成的相邻词，如果在另外一端已经出现过则结束
                //如果没有出现过，而且也是词典中的有效词，并且没有被访问过，则添加入新的Set
                for (int i = 'a'; i <= 'z'; i++) {
                    for (int j = 0; j < chars.length; j++) {
                        char old = chars[j];
                        chars[j] = (char) i;
                        String target = new String(chars);
                        if (endSet.contains(target)) {
                            return steps+1;
                        }
                        if (dicSet.contains(target) && visited.add(target)) {
                            tempSet.add(target);
                        }
                        chars[j] = old;
                    }
                }
            }
            //每次循环都结束都表示当前相邻节点结束，意味着需要进入下一层节点
            //转换步数需要+1
            steps++;
                //把新生成的Set赋值给beginSet,然后重新循环
            beginSet = tempSet;
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
