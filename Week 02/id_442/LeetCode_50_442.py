# https://leetcode-cn.com/problems/powx-n/solution/

# 分治法
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 // x
            n = -n
        return self.fast_pow(x, n)

    def fast_pow(self, x: float, n: int) -> float:
        # 递归终止条件
        if n == 0:
            return 1.0
	# 处理当前层逻辑 并下探到下一层
        half = self.fast_pow(x, n // 2)
        # 合并子问题的结果
        return half * half if n % 2 == 0 else half * half * x
