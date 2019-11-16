//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generate(List<String> list, StringBuilder stringBuilder, int open, int close, int level) {
        if (close == level && open == level) {
            list.add(stringBuilder.toString());
        }
        if (open < level) {
            stringBuilder.append("(");
            generate(list, stringBuilder, open + 1, close, level);
            stringBuilder.setLength(stringBuilder.length()-1);
        }
        if (close < open) {
            stringBuilder.append(")");
            generate(list, stringBuilder, open, close + 1, level);
            stringBuilder.setLength(stringBuilder.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
