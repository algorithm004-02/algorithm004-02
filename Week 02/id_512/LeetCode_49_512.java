package WEEK2.LeetCode.HashTableQuestion;

import java.util.*;

/**
 * No.49
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */


public class GroupAnagram {
    /* 想法第一次只想到了暴力 遍历*/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs){
            String key = hash(w);
            if(!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }
        return new ArrayList<>(map.values());
    }

    String hash(String s){
        int[] a = new int[26];
        for(char c : s.toCharArray()) a[c-'a']++;
        return Arrays.toString(a);
    }

}
