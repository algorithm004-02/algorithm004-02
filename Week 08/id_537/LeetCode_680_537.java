package leetcode.editor.cn;

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串
public class LeetCode_680_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_680_537().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            return isPalindrome(s, 0, s.length() - 1, false);
        }

        private boolean isPalindrome(String s, int i, int j, boolean b) {
            if (i > j)
                return true;
            if (s.charAt(i) == s.charAt(j))
                return isPalindrome(s, i + 1, j - 1, b);
            return !b && (isPalindrome(s, i + 1, j, true) || isPalindrome(s, i, j - 1, true));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}