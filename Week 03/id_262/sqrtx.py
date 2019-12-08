class Solution:
    def mySqrt(self, x: int) -> int:

        # left = 0
        # right = x
        # while left < right:
        #     mid = (left + right + 1) >> 1
        #     square = mid * mid
        #     if square > x:
        #         right = mid - 1
        #     else:
        #         left = mid
        # return left
        if x == 0 or x == 1:
            return x
        left = 0
        right = x
        b = None

        while left < right:

            mid = (right + left) // 2
            if b == mid:
                return mid
            if mid * mid > x:
                right = mid
            elif mid * mid < x:
                left = mid
            elif mid * mid == x:
                return mid
            b = mid


s = Solution()
print(s.mySqrt(9))
