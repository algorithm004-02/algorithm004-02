class Solution:
    '''
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    回溯法
    '''
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def backtrack(i, k, tmp):
            if k == 0:
                res.append(tmp)
                return 
            for j in range(i, n + 1):
                backtrack(j+1, k-1, tmp + [j])
        backtrack(1, k, [])
        return res