package datastruct.dfsAndbfs;

import java.util.*;

/**
 * 126. 单词接龙 II
 *
 *  给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

     每次转换只能改变一个字母。
     转换过程中的中间单词必须是字典中的单词。
     说明:

     如果不存在这样的转换序列，返回一个空列表。
     所有单词具有相同的长度。
     所有单词只由小写字母组成。
     字典中不存在重复的单词。
     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

    示例 1:

     输入:
     beginWord = "hit",
     endWord = "cog",
     wordList = ["hot","dot","dog","lot","log","cog"]
     输出:
     [
     ["hit","hot","dot","dog","cog"],
       ["hit","hot","lot","log","cog"]
     ]

     示例 2:
     输入:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log"]

     输出: []
     解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

 *
 */
public class WordLadder2 {


    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>();

        //"hot","dot","dog","lot","log","cog"
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder2 wl = new WordLadder2();
        System.out.println(wl.findLadders("hit", "cog", wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }

        // 利用 BFS 得到所有的邻居节点
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        bfs(beginWord,endWord,wordList,map);
        ArrayList<String> temp = new ArrayList<>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord,endWord,map,temp,ans);
        return null;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map, ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(temp));
        }

        // 得到所有的下一个的节点
        ArrayList<String> neighbors = map.getOrDefault(beginWord,new ArrayList<>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor,endWord,map,temp,ans);
            temp.remove(temp.size()-1);
        }

    }


    // 利用递归实现双向搜索
    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        bfsHelper(set1,set2,wordSet,true,map);
    }

    // direction 为 true 代表向下扩展，false 代表向上扩展
    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction, HashMap<String, ArrayList<String>> map) {


        /**
         *  set1 为空了，就直接结束
           比如下边的例子就会造成 set1 为空
         * "hot"
		    "dog"
		    ["hot","dog"]
        */
        if (set1.isEmpty()) {
            return false;
        }

        // set1的数量多，就反向扩展
        if (set1.size() > set2.size()) {
            return bfsHelper(set2,set1,wordSet,!direction,map);
        }

        // 将已经访问过单纯删除
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        // 保存新扩展得到的节点
        Set<String> set = new HashSet<>();

        for (String str:set1) {
            // 遍历每一位
            for (int i = 0;i < str.length();i++) {
                char[] chars = str.toCharArray();

                // 尝试所有字母
                for (char ch = 'a';ch <= 'z';ch++) {
                    if(chars[i] == ch) {
                        continue;
                    }

                    chars[i] = ch;
                    String word = new String(chars);

                    // 根据方向得到 map 的 key 和 val
                    String key = direction ? str : word;
                    String val = direction ? word : str;
                    ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();

                    // 如果相遇了就保存结果
                    if (set2.contains(word)) {
                        done = true;
                        list.add(val);
                        map.put(key,list);
                    }

                    // 如果还没有相遇，并且新的单词在word中，那么就加到 set 中
                    if (!done && wordSet.contains(word)) {
                        set.add(word);
                        list.add(val);
                        map.put(key,list);
                    }
                }
            }
        }

        //一般情况下新扩展的元素会多一些，所以我们下次反方向扩展  set2
        return done || bfsHelper(set2, set, wordSet, !direction, map);
    }


}
