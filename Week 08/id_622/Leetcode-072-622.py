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
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        """
                r   o   s
            0   1   2   3
          h 1   1   2   3
          o 2   2   1   2
          r 3   2   2   2
          s 4   3   3   2
          e 5   4   4   3
          二维数组：
          dp[i - 1][j - 1]表示替换
          dp[i][j - 1]表示删除
          dp[i - 1][j]表示替换
          dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1 if word1[i]!=word2[j]
          dp[i][j] = dp[i - 1][j - 1] if word1[i] == word2[j]
        """
        m = len(word1)
        n = len(word2)
        if not word1 or not word2: return 0
        dp = [[0]*(n + 1) for i in range(m + 1)]
        
        for i in range(1, n + 1):
            dp[0][i] = dp[0][i - 1] + 1
            
        for j in range(1, m + 1):
            dp[j][0] = dp[j - 1][0] + 1
            
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
        return dp[-1][-1]