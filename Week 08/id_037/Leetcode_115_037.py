# 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

# 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

# 示例 1:

# 输入: S = "rabbbit", T = "rabbit"
# 输出: 3
# 解释:

# 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
# (上箭头符号 ^ 表示选取的字母)

# rabbbit
# ^^^^ ^^
# rabbbit
# ^^ ^^^^
# rabbbit
# ^^^ ^^^
# 示例 2:

# 输入: S = "babgbag", T = "bag"
# 输出: 5
# 解释:

# 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
# (上箭头符号 ^ 表示选取的字母)

# babgbag
# ^^ ^
# babgbag
# ^^    ^
# babgbag
# ^    ^^
# babgbag
#   ^  ^^
# babgbag
#     ^^^

# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/distinct-subsequences
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


# get到这个动态方程的点了
# 当 j>i && t.at(i)==s.at(j) 情况下dp.at(i).at(j)=dp.at(i).at(j-1)+dp.at(i-1).at(j-1);
# 可以这样子理解
# 假设s="aaa"，t="aa"
# 当 i=1 j=2时即都是对应着最后一个字母
# 刚好满足上面的情况

# dp.at(i-1).at(j-1) 意味着t的最后一个字符一定是匹配s的最后一个字符，即找子序列时，对于t.at(1)他一定是匹配s.at(2)，那么这时候只需要找s和t都去掉最后一个字符后，子序列匹配的个数就可以了，这里结果是2
# dp.at(i).at(j-1) 意味着t的最后一个字符一定不是对应s的最后一个字符，因为在s中可能有重复个字符和t.at(i)相同，那么只需要s删除最后一个字符后再与t来匹配子序列即可
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n1 = len(s)
        n2 = len(t)
        dp = [[0] * (n1 + 1) for _ in range(n2 + 1)]
        for j in range(n1 + 1):
            dp[0][j] = 1
        for i in range(1, n2 + 1):
            for j in range(1, n1 + 1):
                if t[i - 1] == s[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]  + dp[i][j - 1]
                else:
                    dp[i][j] = dp[i][j - 1]
        #print(dp)
        return dp[-1][-1]
