"""
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # 状态转移方程
        # dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
        m = len(word1)
        n = len(word2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        # 第一行，表示如果word1为空，变成word2所需要的步数，插入
        for i in range(1, n + 1):
            dp[0][i] = dp[0][i - 1] + 1
        # 第一列， 表示如果word2为空，变成word2所需要的步数，删除
        for j in range(1, m + 1):
            dp[j][0] = dp[j - 1][0] + 1
        
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # 此部分思考***************
                # Any adjacent value in the matrix dp can only diff by 1. 
                # So dp[i - 1][j - 1] <= dp[i – 1][j] + 1
                # Otherwise we can first transform to dp[i – 1][j] then do one operation to dp[i - 1][j - 1] 
                # and the dp[i-1][j-1] would no longer be the minimum distance. 
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1] ) + 1
        return dp[-1][-1]

    """
    国际站：https://leetcode.com/problems/edit-distance/discuss/25846/C%2B%2B-O(n)-space-DP
      Ø a b c d
    Ø 0 1 2 3 4
    b 1 1 1 2 3
    b 2 2 1 2 3
    c 3 3 2 1 2
    For the base case, that is, to convert a string to an empty string, 
    the mininum number of operations (deletions) is just the length of the string. 
    So we have dp[i][0] = i and dp[0][j] = j.

    For the general case to convert word1[0..i) to word2[0..j), 
    we break this problem down into sub-problems. 
    Suppose we have already known how to convert word1[0..i - 1) to word2[0..j - 1) (dp[i - 1][j - 1]), 
    if word1[i - 1] == word2[j - 1], then no more operation is needed and dp[i][j] = dp[i - 1][j - 1].
    
    Youtube Video:
    https://www.youtube.com/watch?time_continue=310&v=We3YDTzNXEk&feature=emb_logo

      0 a b c d e f
    0 0 1 2 3 4 5 6
    a 1 0 1 2 3 4 5
    3 2 1 1 2 3 4 5
    c 3 2 2 1 2 3 4
    e 4 3 3 2 2 2 3
    d 5 4 4 3 2 3 3
    if word1[i - 1] = word2[j - 1]: dp[i][j] = dp[i - 1][j - 1]
    
    """