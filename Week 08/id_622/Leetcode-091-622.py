"""
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 问题分析，选一个数字的话，则可以1-9，选两个数字的话，则只能大于10，小于26
        # 判断条件成了关键
        # 问题转化为，每增加一个字符，有多少种可能
        # 选1个，则为 dp[i] = dp[i - 1] + dp[i]
        # 选2个，则为 dp[i] = dp[i - 2] + dp[i]
        
        n = len(s)
        if n == 1: 
            if int(s) > 0:
                return 1
            else:
                return 0
        
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1 if int(s[:1]) > 0 else 0

        for i in range(2, n + 1):
            if 1 <= int(s[i - 1 : i]):
                dp[i] += dp[i - 1]
            if 10 <= int(s[i - 2 : i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[n]