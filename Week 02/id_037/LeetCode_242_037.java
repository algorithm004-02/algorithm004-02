// https://leetcode-cn.com/problems/valid-anagram/description/
// 1暴力法， 排序，然后比较两个字符串 最终时间复杂度 O(NlogN)
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray); // 排序时间复杂度用快排，O(NlogN)
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray); // 比较时间复杂度O(N)
    }
}
// 通过hashmap记录各个元素出现的次数,最终时间复杂度O(N)
class Solution2 {
    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if (length != t.length()) return false; // 先保证长度相等
        int[] counters = new int[26]; //26个字母对应数组中26个slot
        // 把counters当成一个散列表，字母的散列函数就是计算字母在26个字母表中所在的序号
        // 遍历两个字符串。s中的字母对应+1， t中的字母将散列表对应位置-1
        
        for (int i = 0; i < length; i++) {
            counters[s.charAt(i) - 'a'] += 1; // O(N)
            counters[t.charAt(i) - 'a'] -= 1; // O(N)
        }
        //遍历检查数组是否各个位置为0, O(1)
        for (int counter : counters) {
            if (counter != 0 ) return false;
        }
        return true;
    }
}

// hash map 将计数与减数放在两个loop中
class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counters = new int[26];
        //记录s中字母数量
        for (int i = 0; i < s.length(); i++) {
            counters[s.charAt(i) - 'a']++;
        }
        //遍历t中字母数量，同时减1，检查当前位置是否为-1，为负则不相等
        for (int i = 0; i < t.length(); i++) {
            counters[t.charAt(i) - 'a']--;
            if (counters[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}