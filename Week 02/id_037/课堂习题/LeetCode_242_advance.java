import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/valid-anagram/description/
// 题目进阶，如果输入的字符是unicode
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (counter.containsKey(s.charAt(i))) {
                counter.put(s.charAt(i), counter.get(s.charAt(i))+1);
            } else {
                counter.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (counter.containsKey(t.charAt(i))) {
                if (counter.get(t.charAt(i)) - 1 < 0) return false;
                counter.put(t.charAt(i), counter.get(t.charAt(i))-1);
            } else {
                return false;
            }
        }
        return true;
    }
}