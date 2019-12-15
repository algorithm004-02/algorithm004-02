
'''
#国际站, 看了

class Solution:
	def minCostClimbingStairs(self, cost: List[int]) -> int:
	    size = len(cost)
	    for i in range(2,size):
	        cost[i]+= min (cost[i-1],cost[i-2])
	    return min(cost[i-1],cost[i])

'''


'''
#the first time
class Solution:
	def minCostClimbingStairs(self, cost: List[int]) -> int:
		size = len(cost)
		dp = [0 for i in range(size + 1)]
		dp[0], dp[1] = cost[0], cost[1]
		for i in range(2, size + 1):
			if i > size - 1:
				y = 0
			else:
				y = cost[i]
			dp[i] = min(dp[i - 2], dp[i - 1]) + y
		return dp[i]
'''

#the third  60ms  ,99.42%
class Solution:
	def minCostClimbingStairs(self, cost: List[int]) -> int:
		size = len(cost)
		# dp=[0  for i in range(size+1)]
		m, n = cost[0], cost[1]
		for i in range(2, size + 1):
			if i > size - 1:
				y = 0
			else:
				y = cost[i]
			m, n = n, min(m, n) + y
		return min(m,n)


# 看了官方题解，发现确实厉害，把 数组倒过来，在思想上，理解为到最左边的最小距离

# 然后启用状态压缩。 还不用初始化数组了。
'''
class Solution(object):
    def minCostClimbingStairs(self, cost):
        f1 = f2 = 0
        for x in reversed(cost):
            f1, f2 = x + min(f1, f2), f1
        return min(f1, f2)

作者：LeetCode
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

'''
