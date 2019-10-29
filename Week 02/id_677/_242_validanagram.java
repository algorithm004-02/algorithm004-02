public class _242_validanagram {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("abc", "bac"));
        System.out.println(s.isAnagram("abc", "bat"));
    }
}

/**
 * 数组下标映射法
 * asymptotic time complexity : O(N)
 * asymptotic space complexity : O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        int[] cache = new int[26];
        for(char c : s.toCharArray()) {
            cache[(int)(c - 'a')]++;
        }
        for (char c : t.toCharArray()) {
            cache[(int)(c - 'a')]--;
        }
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != 0) return false;
        }
        return true;

    }
}

