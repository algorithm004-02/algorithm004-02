"""
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 动态规划
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1) # float("inf"), float("-inf")
        dp[0] = 0
        
        for i in range(1, amount + 1):
            for j in coins:
                if j <= i:
                    dp[i] = min(dp[i], dp[i - j] + 1)
        return -1 if dp[amount] > amount else dp[amount]

    # BFS
    def coinChange(self, coins: List[int], amount: int) -> int:
        step = 0
        queue = [amount]
        visited = set()
        while queue:
            n = len(queue)
            for i in range(n):
                tmp = queue.pop()
                if tmp == 0:
                    return step
                for coin in coins:
                    if tmp >= coin and tmp - coin not in visited:
                        visited.add(tmp - coin)
                        queue.insert(0, tmp - coin)
            step += 1
        return -1