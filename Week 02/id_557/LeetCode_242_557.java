//Given two strings s and t , write a function to determine if t is an anagram of s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your solution to such case? 
// Related Topics Hash Table Sort


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
//思路：先排序再比较
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        char[] schars = s.toCharArray();
//        char[] tchars = t.toCharArray();
//        Arrays.sort(schars);
//        Arrays.sort(tchars);
//        for (int i = 0; i < schars.length; i++) {
//            if (schars[i] != tchars[i]) return false;
//        }
//        return true;
//    }
//}

// 思路：使用一个桶数组，存储出现的次数

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < schars.length; i++) {
            counts[schars[i] - 'a']++;
            counts[tchars[i] - 'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) return false;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
