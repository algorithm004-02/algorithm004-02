package src.main.java.com.fans.algorithm00402.week2.homework;

import java.lang.reflect.Array;
import java.util.*;

/*
【字母异位词分组】
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
 *
 * */
public class LeetCode_49_232 {

    /* 1. 利用Hash对list进行分类 O(N * K * logK) O(NK)  K 代表字符串的最大长度
    *  - 将字符串排序，判断是否相等
    *  - 维护一个映射，保存list
    * */
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        for (int i = 0; i < strs.length; i ++) {
//            String str = strs[i];
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            List<String> list;
//            if (hashMap.get(Arrays.toString(chars)) == null) {
//                list = new ArrayList<>();
//                hashMap.put(Arrays.toString(chars), list);
//            } else {
//                list = hashMap.get(Arrays.toString(chars));
//            }
//            list.add(str);
//        }
//        return new ArrayList(hashMap.values()) ;
//    }

    /* 2. 按计数分类 O(nk) O(n) */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
