# https://leetcode-cn.com/problems/sqrtx/submissions/

# 二分法
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        left, right = 1, x // 2
        while left < right:
            # 取右中位数 取左中位数有可能陷入死循环
            mid = (left + right + 1) >> 1
            if mid * mid > x:
                right = mid - 1
            else:
                left = mid
        return left


# 牛顿迭代法
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        current = 1
        while True:
            previous = current
            current = (current + x / current) / 2
            if abs(current - previous) < 1e-6:
                return int(current)


