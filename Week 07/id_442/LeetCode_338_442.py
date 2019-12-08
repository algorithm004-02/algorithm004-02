# https://leetcode-cn.com/problems/counting-bits/

# 计算每个数二进制为1的个数
class Solution:
    def countBits(self, num: int) -> List[int]:
        result = []
        for i in range(num + 1):
            count = 0
            while i != 0:
                i = i & (i - 1)
                count += 1
            result.append(count)
        return result


# 动态规划递推
class Solution:
    def countBits(self, num: int) -> List[int]:
        result = [0] * (num + 1)
        for i in range(1, num+1):
            result[i] = result[i & (i-1)] + 1
        return result
