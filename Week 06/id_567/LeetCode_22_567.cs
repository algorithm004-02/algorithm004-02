/*
 * @lc app=leetcode.cn id=22 lang=csharp
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.19%)
 * Likes:    622
 * Dislikes: 0
 * Total Accepted:    54.9K
 * Total Submissions: 75.7K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public IList<string> GenerateParenthesis(int n)
    {
        List<string> brackets = new List<string>();
        Backtrack(brackets, "", 0, 0, n);
        return brackets;
    }

    private void Backtrack(List<string> brackets, string str, int left, int right, int max)
    {
        if (str.Length == max * 2)
        {
            brackets.Add(str);
            return;
        }

        if (left < max)
            Backtrack(brackets, str + "(", left + 1, right, max);
        if (right < left)
            Backtrack(brackets, str + ")", left, right + 1, max);
    }
}
// @lc code=end

