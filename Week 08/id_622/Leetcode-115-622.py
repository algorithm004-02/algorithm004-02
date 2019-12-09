"""
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

示例 1:

输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:

如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2:

输入: S = "babgbag", T = "bag"
输出: 5
解释:

如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
(上箭头符号 ^ 表示选取的字母)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distinct-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        # dp[i + 1][j + 1] 代表S[0:j]中含有多少个t[0:i]
        # 如果t为“ ”，则空集为所有字符串的子串，第一行为1
        # 如果s为“ ”，则组成t的子串为0
        # dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j] if t[i] == s[j]
        # dp[i + 1][j + 1] = dp[i + 1][j] if t[i] != s[j]

        """
        s = "acdabefbc", t = "ab"
        
        S   =  acdabefbc
        dp1 = 0111222222

        S   =  acdabefbc
        dp2 = 0000022244
        """
        
        if not s or not t: return 0
        row = len(s)
        col = len(t)
        dp = [[0] * (row + 1) for i in range(col + 1)]
        for i in range(row):
            dp[0][i] = 1
        
        for i in range(col):
            for j in range(row):
                if t[i] == s[j]:
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j]
                else:
                    dp[i + 1][j + 1] = dp[i + 1][j]
        return dp[-1][-1]
                    