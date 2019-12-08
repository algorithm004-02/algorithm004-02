# https://leetcode-cn.com/problems/valid-perfect-square/submissions/

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left, right = 1, num
        while left < right:
            mid = (left + right + 1) >> 1
            if mid * mid > num:
                right = mid - 1
            else:
                left = mid
        return left * left == num
