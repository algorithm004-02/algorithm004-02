# https://leetcode-cn.com/problems/triangle/

# time complexity: O(m*n)
# space complexity: O(n^2)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i+1][j], dp[i+1][j+1])
        return dp[0][0]


# time complexity: O(m*n)
# space complexity: O(n)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        res = triangle[-1]
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j], res[j+1]) + triangle[i][j]
        return res[0]

