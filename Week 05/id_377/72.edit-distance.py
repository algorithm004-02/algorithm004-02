/*
 * @lc app=leetcode id=72 lang=python
 */
// @lc code=start
class Solution(object):
    def minDistance(self, word1, word2):
        l1, l2 = len(word1)+1, len(word2)+1
        dp = range(l2)
        for i in xrange(1, l1):
            pre, dp[0] = i-1, i
            for j in xrange(1, l2):
                buf = dp[j]
                dp[j] = min(dp[j]+1, dp[j-1]+1, pre+(word1[i-1]!=word2[j-1]))
                pre = buf
        return dp[-1]


    # def minDistance(self, word1, word2):
    #     l1, l2 = len(word1)+1, len(word2)+1
    #     pre = [0 for _ in xrange(l2)]
    #     for j in xrange(l2):
    #         pre[j] = j
    #     for i in xrange(1, l1):
    #         cur = [i]*l2
    #         for j in xrange(1, l2):
    #             cur[j] = min(cur[j-1]+1, pre[j]+1, pre[j-1]+(word1[i-1]!=word2[j-1]))
    #         pre = cur[:]
    #     return pre[-1]
// @lc code=end