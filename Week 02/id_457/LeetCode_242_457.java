/**
    哈希表
    时间复杂度：O(n)。时间复杂度为 O(n)因为访问计数器表是一个固定的时间操作。
    空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，
                因为无论 N 有多大，表的大小都保持不变。
*/
class Solution {
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {  //注意：此处为 !=
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i<s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        for (int j = 0; j<t.length(); j++) {
            counts[t.charAt(j)-'a']--;
            if (counts[t.charAt(j)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}