import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.69%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    33.7K
 * Total Submissions: 57.1K
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

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 先排序，然后放入一个Hashmap
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String word = Arrays.toString(chars);
            if (!anagrams.containsKey(word)) {
                anagrams.put(word, new ArrayList<String>());
            }
            anagrams.get(word).add(strs[i]);
        }
        return new ArrayList<>(anagrams.values());
    }
}
// @lc code=end
