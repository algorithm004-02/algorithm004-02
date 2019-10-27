//[49]字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;

public class GroupAnagrams {

    /**
     * Soluation1
     * 寻找hash编码
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = hash(str);
            map.compute(hash, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(str);
                return v;
            });
        }

        return new ArrayList<>(map.values());
    }

    public String hash(String value) {

        if (value == null || value.length() == 0) {
            return "0";
        }

        int[] count = new int[26];
        for (int i = 0; i < value.length(); i++) {
            count[value.charAt(i) - 'a']++;
        }

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                buffer.append(i).append('#').append(count[i]).append(":");
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}