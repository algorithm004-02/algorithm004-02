/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<String>());
            }
            map.get(sortStr).add(s);
        }
        return new ArrayList(map.values());
    }
}
// @lc code=end
