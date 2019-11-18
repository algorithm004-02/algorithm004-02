package com.itliusir.hash;

import java.util.*;

/**
 * problem.20
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author liugang
 * @date 2019-10-23
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagramsTwo(strs);
        lists.forEach(l -> {
            l.forEach(s -> {
                System.out.print(s + " ");
            });
            System.out.println();
        });
    }

    /**
     * method 1 -> time O(n * max(str) * log n) space O(n * max(str))
     *
     * @author liugang
     * @date 2019-10-23 09:38:49
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * method 2 -> time O(n * max(str)) space O(n * max(str))
     * @author liugang
     * @date 2019-10-23 10:51:38
     */
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        int[] words = new int[26];
        for (String str : strs) {
            // set zero again
            Arrays.fill(words, 0);
            char[] chars = str.toCharArray();
            // count the number of each char
            for (char aChar : chars) {
                words[aChar - 'a']++;
            }
            // build key
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(words[i]);
            }
            // fill map
            String key = stringBuilder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
