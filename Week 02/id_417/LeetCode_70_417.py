class Solution:
    # 重新用带cache的递归写了一遍爬楼梯问题
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        
        return self.cache(n, [])
    
    def cache(self, n: int, cache_: list):
        if n == 0:
            return 1
        elif n <= len(cache_):
            return cache_[n-1]
        elif n == 1:
            cache_.append(1)
            return 1
        else:
            r = self.cache(n-2, cache_) + self.cache(n-1, cache_)
            cache_.append(r)
            return r
        
