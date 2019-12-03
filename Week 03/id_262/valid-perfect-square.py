class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 0 or num == 1:
            return True
        start = 0
        end = num
        b = None

        while start < end:
            mid = (end + start) >> 1

            if mid == 0 or mid == b:
                return False

            if mid * mid > num:
                end = mid
            elif mid * mid < num:
                start = mid
            elif mid * mid == num:
                return True
            b = mid
