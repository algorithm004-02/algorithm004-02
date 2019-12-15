class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        #将每一行看作一个二进制数，然后转化为一个整数
        nums = [int(''.join(row), base=2) for row in matrix]
        ans, N = 0, len(nums)
        #遍历所有行
        for i in range(N):
            j, num = i, nums[i]
            #将第i行，连续的，和接下来的所有行，做与运算
            while j < N:
                #经过与运算后，num转化为二进制中的1，表示从i到j行，可以组成一个矩形的那几列
                num = num & nums[j]
                if not num:
                    break
                l, curnum = 0, num
                #这个循环最精彩
                #每次循环将curnum和其左移一位的数做与运算
                #最终的循环次数l表示，最宽的有效宽度，
                while curnum:
                    l += 1
                    curnum = curnum & (curnum << 1)
                ans = max(ans, l * (j - i + 1))
                j += 1
        return ans