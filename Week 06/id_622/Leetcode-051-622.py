"""
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        """
        解决此类问题，最好的思想是自顶向下的编程思想
        条件数据：根据题目特性准备条件数据
        解决方案：解决方案分为模版方案和具体问题
                模版方案：主要套用回溯，递归等模版
                具体问题：根据实际的case，思考问题的本质，分解出最小子问题
                本题的，遍历每一行，把访问过的结果存起来，col, pie, na
                再比较是否访问过，如果是，则回退
        输出结果
        """
        if n == 0: return []
        self.res = []
        
        # 定义列，撇，捺，后续传入对应的坐标
        # 对于撇row + col y = x，捺 row - col y = -x
        self.cols = set(); self.pie = set(); self.na = set()
        self.dfs(n, 0, [])
        # [1, 3, 0, 2]
        """
            .Q..
            ...Q
            Q...
            ..Q.
        """
        # val = [ ["." * j + "Q" + "." * (n - j - 1) for j in i] for i in self.res ]
        return [ ["." * j + "Q" + "." * (n - j - 1) for j in i] for i in self.res ]
    
    def dfs(self, n, row, cur_state):
        # Terminator
        if row >= n:
            self.res.append(cur_state)
            return
        
        # Process
        for col in range(n):
            # 剪枝
            if col in self.cols or row + col in self.pie or row - col in self.na:
                continue
            
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)
            
            # Drill Down
            self.dfs(n, row + 1, cur_state + [col])
            
            # Reverse State
            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        def dfs(queens, xy_diff, xy_sum):
            p = len(queens)
            # Terminator
            if n == p:
                result.append(queens)
                return
            
            for q in range(n):
                if q not in queens and p - q not in xy_diff and p + q not in xy_sum:
                    dfs(queens + [q], xy_diff + [p - q], xy_sum + [p + q])

        dfs([], [], [])
        return [["."*i + "Q" + "."*(n - i - 1) for i in el] for el in result]

        