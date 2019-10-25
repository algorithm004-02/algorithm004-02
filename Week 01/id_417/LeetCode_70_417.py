class Solution:
    def climbStairs(self, n: int) -> int:
        # 可以理解成一个排列组合问题
        # 1阶的数量x和2阶的数量y满足以下要求：x+2y=n
        # 那么x和y的数量组合有以下几种
        # (n, 0), (n-2, 1), ..., (n-[n/2]*2, [n/2])
        # 对于其中一个方案(n-2m, m)，其组合为C(n-m, m)
        # 所有方案的和就是实际的方法总数
        
        total = 0
        for m in range(int(n/2)+1):
            total += self.combination(n-m, m)
        
        return total
    
    def combination(self, n: int, m: int) -> int:
        if m == 0:
            return 1
        else:
            return int(self.combination(n-1, m-1) * n / m)
