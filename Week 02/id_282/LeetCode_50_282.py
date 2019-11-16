class Solution:
    '''
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    '''
    def myPow(self, x: float, n: int) -> float:
        if n < 0 : return self.myPow(1 / x, -n)
        if n == 0: return 1
        if n % 2 == 0:
            return self.myPow(x*x, n//2)
        else:
            return x * self.myPow(x*x, n//2)
