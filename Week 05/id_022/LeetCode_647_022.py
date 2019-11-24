#[647]回文子串
#
#给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
#
# 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
#
# 示例 1: 
#
# 
#输入: "abc"
#输出: 3
#解释: 三个回文子串: "a", "b", "c".
# 
#
# 示例 2: 
#
# 
#输入: "aaa"
#输出: 6
#说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
# 
#
# 注意: 
#
# 
# 输入的字符串长度不会超过1000。 
# 
# Related Topics 字符串 动态规划


class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        count = 0
        dp = [[0] * n for _ in range(n)]
        for j in range(n):
            for i in range(j + 1):
                if i == j or (s[i] == s[j] and (j - i <= 1 or dp[i + 1][j - 1] == 1)):
                    dp[i][j] = 1
                    count += 1
        # print(dp)
        return count
