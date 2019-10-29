"""
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 分治法
    def myPow(self, x: float, n: int) -> float:
        y = n if n >= 0 else -n
        def recursion(x, n):
            if n == 0: return 1.0
            half = recursion(x, int(n/2))
            return half * half if n % 2 == 0 else half * half * x
        return recursion(x, y) if n >= 0 else 1 / recursion(x, y)

    # 自身递归
    def myPow(self, x: float, n: int) -> float:
        if n == 0: return 1.0
        half = self.myPow(x, abs(int(n/2)))
        ans = half * half if n % 2 == 0 else half * half * x
        return ans if n >= 0 else 1 / ans