# 爬楼梯
# 1：1
# 2：2
# 3：f(1) + f(2), mutual exclusive, complete exhaustive
# 4: f(2) + f(3)
# f(n) = f(n-1) + f(n-2) : Fibonacci

# 动态规划


# class Solution:
#     def climbStairs(self, n: int) -> int:
#         if (n <= 2):
#             return n
#         f1, f2, f3 = 1, 2, 3
#         for i in range(3, n+1):
#             f3 = f1+f2
#             f1 = f2
#             f2 = f3
#         return f3
####################傻递归#################
# 空间复杂度：O(n)，递归树的深度可以达到 n
# 超时，但也写写吧

# class Solution:
#     def climbStairs(self, n: int) -> int:
#         if n == 1:
#             return 1
#         elif n == 2:
#             return 2
#         else:
#             return self.climbStairs(n - 1) + self.climbStairs(n - 2)

##################3记忆化递归###########
class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [n+1]
        return self.climb_Stairs(0, n, memo)

    def climb_Stairs(self, i: int, n: int, memo: list):
        if i > n:
            return 0
        if i == n:
            return 1
        if memo[i] > 0:
            return memo[i]
        memo[i] = self.climb_Stairs(
            i+1, n, memo) + self.climb_Stairs(i+2, n, memo)
        return memo[i]

###################缓存#####################
# import functools
# class Solution:
#     @functools.lru_cache(None)
#     def climbStairs(self, n: int) -> int:
#         if n == 0:return 1
#         if n == 1:return 1
#         return self.climbStairs(n-1) + self.climbStairs(n-2)

#######################测试用例#######################
n = 10
obj = Solution()
print(obj.climbStairs(n))
