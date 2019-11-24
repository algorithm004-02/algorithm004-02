# 分治 problem(i, j) = min(subproblem(i+1, j), subproblem(i+1, j+1)) + a(i,j)
# 状态数组 dp[i,j]
# dp： dp[i, j] = min(dp[i+1, j], dp[i+1, j+1]) + dp[i, j]
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return
        for i in xrange(len(triangle) - 2, -1, -1):
            for j in xrange(len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]