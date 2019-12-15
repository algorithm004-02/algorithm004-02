'''
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        l, r = 1, num//2
        while l < r:
            mid = (l + r) // 2
            if mid * mid < num:
                l = mid + 1
                #print("ff")
            else:
                r = mid
                #print("rrrrr")
        return l * l == num
        '''


# 只在最后判断一次，二分只管收缩，很好。

# 我的代码

class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1: return True
        if num == 2: return False
        if num == 3: return False
        if num == 4: return True

        l, r = 2, num // 2  # 这里优化了一次

        while l < r:
            mid = l + r + 1 >> 1

            kk = mid * mid
            if kk == num:
                return True

            elif kk > num:
                r = mid - 1
            else:
                l = mid
        return False


''' 找了一个大数，测试了以下，结果不对。
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        i = num
        while i * i > num:
            i = (i + num / i) // 2
        return i * i == num


我找了一个测试用例，43537405842735850251441 = 208656190521*208656190521 ，牛顿迭代出问题了。结果不正确。
'''
