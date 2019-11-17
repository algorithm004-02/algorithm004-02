class Solution:
    def uniquePaths(self,m,n):
        #m,n 长宽
        if m==0 or n==0:
            return 0
        row_path=[1]*n
        for i in range(1,m):
            for j in range(1,n):
                row_path[j]+=row_path[j-1]
        return row_path[-1]

if __name__=='__main__':
    ss=Solution()
    print(ss.uniquePaths(3,2))






