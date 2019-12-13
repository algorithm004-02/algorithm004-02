//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int[] counts = new int[26];
            for (int j = 0; j < chars.length; j++) {
                counts[chars[j] - 'a']++;
            }
            String key = Arrays.toString(counts);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> newArray=new ArrayList<>();
                newArray.add(strs[i]);
                map.put(key,newArray);
            }
        }
        return new ArrayList<>(map.values());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
