package leetcode;/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.60%)
 * Likes:    196
 * Dislikes: 0
 * Total Accepted:    32.2K
 * Total Submissions: 54.9K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

// @lc code=start
class GroupAnagrams {

    public static void main(String[] args) {
        String[] msgs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = method(msgs);
        list.forEach(x->{
            x.forEach(y->{
                System.out.print(y+",");
            });
            System.out.println();
        });
    }

    public static List<List<String>> method(String[] strs) {
//        List<List<String>> results = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0;i<strs.length;i++) {
            char[] chars1 = strs[i].toCharArray();
            Arrays.sort(chars1);
            String key = String.valueOf(chars1);
            List<String> list = map.containsKey(key)?map.get(key):new ArrayList<>();
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> method2(String[] strs) {
//        List<List<String>> results = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0;i<strs.length;i++) {
            char[] chars1 = strs[i].toCharArray();
            Arrays.sort(chars1);
            String key = String.valueOf(chars1);
            List<String> list = map.containsKey(key)?map.get(key):new ArrayList<>();
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }


    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int anagram[] = new int[26], anagramlength = s.length(),index = -1;
        for(char c: s.toCharArray()) anagram[c-'a']++;
        while(++index<t.length()){
            if(anagram[t.charAt(index)-'a']-->0) anagramlength--;
        }
        return anagramlength==0;
    }
}
// @lc code=end

