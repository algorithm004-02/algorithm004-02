import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/group-anagrams/
// 遍历数组，将字符串元素转化为数组，排序，然后用排序过的字符串作为key,记录在result中的位置
// 假设最大字符串长度是K，最坏时间复杂度O(N*KlogK）
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList(strs.length);
        Map<String, Integer> grouper = new HashMap<>();
        int index = 0;
        for (String str : strs) { // 时间复杂度O(N)
            char[] charArr = str.toCharArray(); 
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if (grouper.containsKey(sortedStr)) {
                int pos = grouper.get(sortedStr);
                result.get(pos).add(str);
            } else {
                grouper.put(sortedStr, index++);
                List<String> unit = new ArrayList();
                unit.add(str);
                result.add(unit);
                
            }
        }
        return result;
    }
}
// 自己写leetcode的官方答案，按排序字符串分类，与我的答案思路相近，比我的写的漂亮
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> result = new HashMap();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);
            if (!result.containsKey(sortedStr)) result.put(sortedStr, new ArrayList());
            result.get(sortedStr).add(str);
        }
        return new ArrayList(result.value());
    }
}
// leetcode 官方答案计数法，计数法记得数字在concat成一个字符串时，需要用特殊字符进行分离，此处用的是hash符号
// 复杂度O（KN）
class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> result = new HashMap();
        int[] count = new int[26];
        for (String str : strs) { // 复杂度O(N)
            Arrays.fill(count, 0);
            char[] charArr = str.toCharArray();
            for (char c : charArr) count[c - 'a']++; //假设最长字符串为K，复杂度O(K)
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append('#');
                sb.append(num);
            }
            String key = sb.toString();
            if (!result.containsKey(key)) result.put(key, new ArrayList());
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }
}