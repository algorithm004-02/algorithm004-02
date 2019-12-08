"""
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:

输入: 1
输出: true
解释: 20 = 1
示例 2:

输入: 16
输出: true
解释: 24 = 16
示例 3:

输入: 218
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-two
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        """
        二进制中有且仅有一个1
        n & (n - 1) 清除最后一个1，如：
        1000 & 0111 = 0000
        1101 & 1100 = 1100
        """
        return n > 0 and n & (n - 1) == 0

    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        """
        二进制中有且仅有一个1
        熟练掌握取模的位运算 n & 1 == 0 等价于 n % 2 == 0
        """
        if n <= 0: return False
        while n & 1 == 0:
            n >>= 1
        return n == 1