/*
    22. 括号生成
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */

// 解法 1:回溯
// 思路: 尝试生成尽可能多的"(", 直到不满足条件(这里是等于给定数字), 然后递归生成")"
public class Solution
{
    public IList<string> GenerateParenthesis(int n)
    {
        List<string> list = new List<string>();

        BackTrack(list, "", 0, 0, n);

        return list;
    }

    private void BackTrack(List<string> list, string curr, int open, int close, int max)
    {
        if (open == max && close == max)
        {
            list.Add(curr);
            return;
        }

        if (open < max) BackTrack(list, curr + "(", open + 1, close, max);
        if (close < open) BackTrack(list, curr + ")", open, close + 1, max);
    }
}