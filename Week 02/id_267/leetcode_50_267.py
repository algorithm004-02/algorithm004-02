# 1. 暴力
# result = 1
# for i in range(n):
#     result *=x
# O(n)

# 2. 分治
# template： 1. terminator 2. process (split your big problem) 3. drill down (subproblems), merge(subresult) 4. reverse states

#     x^n --> 2^10 : 2^5 --> (2^2)*2

#     pow(x, n):
#         subproblem: pow(x, n/2)
#
    #  merge:
    #     if n % 2 == 1:
    #         # odd
    #         result = subresult * subresult * x
    #     else:
    #         # even
    #         result = subresult * subresult
# O(logn)

class Solution:
    def myPow(self, x, n) -> float:
        if n < 0:
            x = 1 / x
        return self.myPowHelper(x * x, int(n / 2), 1) if n % 2 == 0 else self.myPowHelper(x * x, int(n / 2), x)
            
            
    def myPowHelper(self, x, n, re) -> float:
        if n == 0:
            return re
        elif n == 1:
            return x * re
        else:
            return self.myPowHelper(x * x, int(n / 2), re) if n % 2 == 0 else self.myPowHelper(x * x, int(n / 2), x * re)

# 3. 牛顿迭代法

################test cases##############
obj = Solution()
print(obj.myPow(-2, 9))