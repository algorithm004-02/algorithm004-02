import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {

    // 方法一：暴力求解：排序，比较相等 4ms
    public boolean isAnagram(String s, String t) {
        // 断言
        if (s.length() != t.length()) {
            return false;
        }

        // 字符排序
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);

        // 不能调用 cs.equals(ct);
        return Arrays.equals(cs, ct);
    }

    // 方法二： 创造哈希表 4ms、7ms
    public boolean isAnagram2(String s, String t) {

        // 断言
        if (s.length() != t.length()) {
            return false;
        }

        /**
         * 1. 手动创建一个数组，a放在0位置。for循环，将出现次数放入对应的位置。 2. 第二次for循环对比，每次-1. 3.
         * 因为长度一致，则若不相等，则一定存在小于0的情况。若小于0，则不存在。 4. 也可以两次循环完毕，最后在对比。属于小的差异化处理。
         */
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            /**
             * 使用 int index = t.charAt(j) - 'a' ，可以将7ms优化到4ms。 不能使用 int num =
             * table[t.charAt(j) - 'a']--、int num = table[t.charAt(j) - 'a'] - 1
             */
            int index = t.charAt(j) - 'a';
            table[index]--;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

    // 方法三： 直接使用哈希表。因为装箱的原因，反而效率最差 20ms
    public boolean isAnagram3(String s, String t) {

        // 断言
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer v = map.get(c);
            if (v == null) {
                v = 0;
            }
            map.put(c, v + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer v = map.get(c);
            if (v == null) {
                return false;
            }
            if (v - 1 < 0) {
                return false;
            }
            map.put(c, v - 1);
        }
        return true;
    }
}
// @lc code=end
