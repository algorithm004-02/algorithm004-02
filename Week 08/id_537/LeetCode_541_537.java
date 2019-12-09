package leetcode.editor.cn;

//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
//
// 示例: 
//
// 
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 要求: 
//
// 
// 该字符串只包含小写的英文字母。 
// 给定字符串的长度和 k 在[1, 10000]范围内。 
// 
// Related Topics 字符串
public class LeetCode_541_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_541_537().new Solution();
        solution.reverseStr("abcdefg", 2);
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            if (k == 1) {
                return s;
            }
            char[] chars = s.toCharArray();
            char c;
            int p;
            int q;
            for (int i = 0; i < chars.length; i += 2 * k) {
                q = i;
                p = Math.min(i + k - 1, chars.length - 1);
                while (p > q) {
                    c = chars[p];
                    chars[p--] = chars[q];
                    chars[q++] = c;
                }
            }

            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}