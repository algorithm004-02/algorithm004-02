//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

//思路：使用BFS找出相邻节点，在 BFS 中，如果发现有邻接节点在之前已经出现过了，我们直接把这个邻接节点删除不去。这样的话，在 DFS 中就不用再判断了，直接取邻居节点就可以了。
//判断之前是否已经处理过，可以用一个 HashSet 来把之前的节点存起来进行判断。
//这里删除邻接节点需要用到一个语言特性，java 中遍历 List 过程中，不能对 List 元素进行删除。如果想边遍历边删除，可以借助迭代器。
//class Solution {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        // 利用 BFS 得到所有的邻居节点
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        bfs(beginWord, endWord, wordList, map);
//        ArrayList<String> temp = new ArrayList<String>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, map, temp, ans);
//        return ans;
//    }
//
//    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
//                                   ArrayList<String> temp, List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            ans.add(new ArrayList<String>(temp));
//            return;
//        }
//        // 得到所有的下一个的节点
//        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
//        for (String neighbor : neighbors) {
//            temp.add(neighbor);
//            findLaddersHelper(neighbor, endWord, map, temp, ans);
//            temp.remove(temp.size() - 1);
//
//        }
//    }
//
//    public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        boolean isFound = false;
//        int depth = 0;
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            Set<String> subVisited = new HashSet<>();
//            for (int j = 0; j < size; j++) {
//                String temp = queue.poll();
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbors(temp, dict);
//                Iterator<String> it = neighbors.iterator();//把元素导入迭代器
//                while (it.hasNext()) {
//                    String neighbor = it.next();
//                    if (!visited.contains(neighbor)) {
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                        }
//                        queue.offer(neighbor);
//                        subVisited.add(neighbor);
//                    } else {
//                        it.remove();
//                    }
//                }
//                map.put(temp, neighbors);
//            }
//            visited.addAll(subVisited);
//            if (isFound) {
//                break;
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<String>();
//        char chs[] = node.toCharArray();
//
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch)
//                    continue;
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//
//        }
//        return res;
//    }
//}

//class Solution{
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        // 如果不含有结束单词，直接结束，不然后边会造成死循环
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        bfs(beginWord, endWord, wordList, ans);
//        return ans;
//    }
//
//    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
//        Queue<List<String>> queue = new LinkedList<>();
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        queue.offer(path);
//        boolean isFound = false;
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Set<String> subVisited = new HashSet<>();
//            for (int j = 0; j < size; j++) {
//                List<String> p = queue.poll();
//                //得到当前路径的末尾单词
//                String temp = p.get(p.size() - 1);
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbors(temp, dict);
//                for (String neighbor : neighbors) {
//                    //只考虑之前没有出现过的单词
//                    if (!visited.contains(neighbor)) {
//                        //到达结束单词
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                            p.add(neighbor);
//                            ans.add(new ArrayList<String>(p));
//                            p.remove(p.size() - 1);
//                        }
//                        //加入当前单词
//                        p.add(neighbor);
//                        queue.offer(new ArrayList<String>(p));
//                        p.remove(p.size() - 1);
//                        subVisited.add(neighbor);
//                    }
//                }
//            }
//            visited.addAll(subVisited);
//            if (isFound) {
//                break;
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<String>();
//        char chs[] = node.toCharArray();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch)
//                    continue;
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//
//        }
//        return res;
//    }
//
//}

class Solution{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        // 利用 BFS 得到所有的邻居节点
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map);
        ArrayList<String> temp = new ArrayList<String>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                   ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        // 得到所有的下一个的节点
        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, map, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    //利用递归实现了双向搜索
    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
        Set<String> set1 = new HashSet<String>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<String>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<String>(wordList);
        bfsHelper(set1, set2, wordSet, true, map);
    }

    // direction 为 true 代表向下扩展，false 代表向上扩展
    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction,
                              HashMap<String, ArrayList<String>> map) {
        //set1 为空了，就直接结束
        //比如下边的例子就会造成 set1 为空
    /*	"hot"
		"dog"
		["hot","dog"]*/
        if(set1.isEmpty()){
            return false;
        }
        // set1 的数量多，就反向扩展
        if (set1.size() > set2.size()) {
            return bfsHelper(set2, set1, wordSet, !direction, map);
        }
        // 将已经访问过单词删除
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        // 保存新扩展得到的节点
        Set<String> set = new HashSet<String>();

        for (String str : set1) {
            //遍历每一位
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // 尝试所有字母
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if(chars[i] == ch){
                        continue;
                    }
                    chars[i] = ch;

                    String word = new String(chars);

                    // 根据方向得到 map 的 key 和 val
                    String key = direction ? str : word;
                    String val = direction ? word : str;

                    ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                    //如果相遇了就保存结果
                    if (set2.contains(word)) {
                        done = true;
                        list.add(val);
                        map.put(key, list);
                    }

                    //如果还没有相遇，并且新的单词在 word 中，那么就加到 set 中
                    if (!done && wordSet.contains(word)) {
                        set.add(word);
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        //一般情况下新扩展的元素会多一些，所以我们下次反方向扩展  set2
        return done || bfsHelper(set2, set, wordSet, !direction, map);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
