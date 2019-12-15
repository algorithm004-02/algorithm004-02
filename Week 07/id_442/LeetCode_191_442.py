# https://leetcode-cn.com/problems/number-of-1-bits/

# 转为字符串 遍历字符串每一位 累加1的个数
class Solution:
    def hammingWeight(self, n: int) -> int:
        count, s = 0, bin(n)
        for i in s:
            if i == '1':
                count += 1
        return count

# 取模+除2 遍历1的个数
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n != 0:
            if n & 1 == 1:
                count += 1
            n //= 2
        return count

# 位运算 每次清零最低位的1
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n != 0:
            n = n & (n - 1)
            count += 1
        return count

