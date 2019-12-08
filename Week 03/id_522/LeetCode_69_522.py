'''第一次
class Solution:
    def mySqrt(self, x):
        # def mySqrt(self, x: int) -> int:

        if x == 0 or x == 1: return x

        left = 0
        right = x
        loopcount=0
        while left < right  and loopcount < 65:  #当写不定次循环时，这个要绷着。
            loopcount+=1
            mid = left + right + 1 >> 1  #不收敛的情况 +1

            if mid * mid == x:
                return mid

            elif mid * mid > x:
                right = mid - 1
            else:
                left = mid  #不收敛的情况
        return left
'''


# 第二次
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0: return 0  # 这里比我写的好

        left = 1  # 初始值变化为1
        right = x // 2  # 这里比我写的好

        while left < right:
            # 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1
            # square = mid * mid   #临时变量，只用一次，删除

            if mid * mid > x:
                right = mid - 1
            else:
                left = mid
        # 因为一定存在，因此无需后处理
        return left


# 写一个牛顿的，
'''
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0: return 0  # 这里比我写的好
        if x == 1 or x == 2 or x == 3: return 1  #x**2 -4x <0

        cur = x // 2  # 这里比我写的好

        while True:
            pre = cur
            cur = (cur + x / cur) / 2  #基于一阶导数，泰勒公式
            if abs(cur - pre) < 1e-6:
                return int(cur)
'''
