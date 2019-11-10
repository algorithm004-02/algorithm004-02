/**
 * 126. 单词接龙 II  （看晕了）
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<List<String>>();

        if (!wordList.contains(endWord)) {
            return resList;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map);
        // temp 用来保存当前的路径
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, resList);
        return resList;
    }

    private void findLaddersHelper(String beginWord, String endWord,
                                   HashMap<String, ArrayList<String>> map,
                                   ArrayList<String> temp,
                                   List<List<String>> resList) {
        if (beginWord.equals(endWord)) {
            resList.add(new ArrayList<String>(temp));
            return;
        }

        //得到所有的下一个的节点
        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, map, temp, resList);
            temp.remove(temp.size()-1);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
        Set<String> set1 = new HashSet<String>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<String>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<String>(wordList);
        bfsHelper(set1, set2, wordSet, true, map);
    }

    //direction 为 true 代表向下扩展，false 代表向上扩展
    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction,HashMap<String, ArrayList<String>> map) {
        if (set1.isEmpty()) {
            return false;
        }

        //set1的数量多，就反向扩展
        if (set1.size() > set2.size()) {
            return bfsHelper(set2, set1, wordSet, !direction, map);
        }

        //删除已经访问过的单词
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        //保存新扩展得到的节点
        Set<String> set = new HashSet<String>();

        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) {
                        continue;
                    }

                    chars[i] = ch;

                    String word = new String(chars);

                    String key = direction ? str : word;
                    String val = direction ? word : str;

                    ArrayList<String> list =  map.containsKey(key) ? map.get(key) : new ArrayList<String>();

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