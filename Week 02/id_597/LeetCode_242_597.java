import java.util.Arrays;

/**
 * 有效的字母异位词
 * Created by yangwenwei on 2019/10/22.
 */
public class LeetCode_242_597 {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram1("a", "b"));
    }

    static class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }

            for (int count : counter) {
                if (count != 0)
                    return false;
            }
            return true;
        }

        public boolean isAnagram1(String s, String t) {
            if (s.length() != t.length()) return false;
            //要用int数组
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;
            for (int i = 0; i < t.length(); i++)
                if (--counter[t.charAt(i) - 'a'] < 0) return false;
            return true;
        }

        /*
        时间复杂度：O(nlog n)，假设 n 是 s的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。
        排序时间占主导地位，总体时间复杂度为 O(nlogn)。
        空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1) 辅助空间。
        在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间，但是我们忽略了这一复杂性分析
        这依赖于语言的细节。这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
         */
        public boolean isAnagram2(String s, String t) {
            if (s.length() != t.length())
                return false;
            char[] sA = s.toCharArray();
            char[] tA = t.toCharArray();
            Arrays.sort(sA);
            Arrays.sort(tA);
            return Arrays.equals(sA, tA);
        }

    }
}


