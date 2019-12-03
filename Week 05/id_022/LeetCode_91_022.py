#[91]解码方法
#
#一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
# 'A' -> 1
#'B' -> 2
#...
#'Z' -> 26
# 
#
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
#
# 示例 1: 
#
# 输入: "12"
#输出: 2
#解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
# 
#
# 示例 2: 
#
# 输入: "226"
#输出: 3
#解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
# 
# Related Topics 字符串 动态规划

class Solution:
    def numDecodings(self, s: str) -> int:

        if s[0] == '0':
            return 0

        dp = [0] * len(s)
        dp[0] = 1

        for i in range(1, len(s)):
            n0, n1 = s[i - 1], s[i]
            if n1 == '0':
                if n0 not in ['1', '2']:
                    return 0
                else:
                    dp[i] = dp[i - 2] if i > 1 else 1
            elif n0 == '1' or (n0 == '2' and n1 <= '6'):
                dp[i] = dp[i - 1] + (dp[i - 2] if i > 1 else 1)
            else:
                dp[i] = dp[i - 1]

        return dp[-1]
