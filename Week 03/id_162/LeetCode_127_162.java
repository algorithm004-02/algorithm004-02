import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * 关键思路: 预处理, 双端BFS, 避免重复访问, 递归, 总是从少找向多
     * 预处理：找出相邻的节点，即只差一个字母的两个单词。为了快速的找到这些相邻节点，我们对给定的 wordList 做一个预处理，将单词中的某个字母用 * 代替。
     * 双端广度优先：从begin->end遍历和从end->begin同时进行，当待遍历的队列哪个短先遍历哪个。
     * 由少的找多的: 你来找我的下一回合有五个路口，我来找你下一回合可能有十个路口，那你来找我更快（每次递归前都判断下）
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0; // O(n)
        if (beginWord.equals(endWord)) return 2;

        // 预处理 双端广度优先 避免重复访问 递归 总是从少找向多
        // 预处理
        Map<String, Set<String>> patternMap = this.getPatternMap(wordList);

        // 双端广度优先
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();

        // 递归
        return this.search(1, beginSet, endSet, visited, patternMap);
    }

    private int search(int level, Set<String> beginSet, Set<String> endSet, Set<String> visited, Map<String, Set<String>> patternMap) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0; // 双端都找不到了

        // process
        visited.addAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();

        // 遍历beginSet
        for (String beginWord : beginSet) {
            Set<String> neighbors = this.getNeighbors(beginWord, patternMap);
            // 遍历所有相邻词
            for (String neighbor : neighbors) {
                if (visited.contains(neighbor)) continue; // 避免重复访问
                if (endSet.contains(neighbor)) return level; // 已找到
                // 未找到，把相邻词记入下一层
                nextLevelSet.add(neighbor);
            }
            // 不能再此处 nextLevelSet.addAll(neighbors); 因为不能将 visited.contains(neighbor) 的节点放入 nextLevelSet
        }

        // drill down
        // 判断质朴的路程的总和，总是从少找向多
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }

        return this.search(level, beginSet, endSet, visited, patternMap);

        // reverse state
    }

    // 返回给定单词表的所有匹映射，key为带*的匹配键，value为改匹配键可对应的单词集合
    private Map<String, Set<String>> getPatternMap(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            Set<String> keys = this.getPatterns(word);
            for (String key : keys) {
                if (!map.containsKey(key)) {
                    map.put(key, new HashSet<>());
                }
                map.get(key).add(word);
            }
        }
        return map;
    }

    // 返回给定单词的所有可能的带*匹配键
    private Set<String> getPatterns(String word) {
        Set<String> res = new HashSet<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = '*';
            res.add(String.valueOf(arr));
            arr[i] = temp;
        }
        return res;
    }

    // 返回给定单词、在给定匹配映射中的所有可能的相邻单词
    private Set<String> getNeighbors(String word, Map<String, Set<String>> patternMap) {
        Set<String> res = new HashSet<>();
        Set<String> patterns = this.getPatterns(word);
        for (String pattern : patterns) {
            if (!patternMap.containsKey(pattern)) continue;
            res.addAll(patternMap.get(pattern));
        }
        return res;
    }
}
