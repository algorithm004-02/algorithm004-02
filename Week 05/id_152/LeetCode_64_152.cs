/*
   DP: 
   Intuition: 类似于unit paths以及三角形最小路径和的问题。都是二维的dp
   a. 最近重复性和最小子问题：[i, j]到 bottom right 的min Path sum
   最小和则存在最优子结构
   problem[i, j] = Min(subproblem[i+1,j], subproblme[i, j+1]) + nums[i, j]
   b. 定义状态空间和状态方程：dp[i, j]
   c. 状态转移方程：you can only move either down or right
          dp[i, j] = Math.Min(dp[i+1, j], dp[i, j+1]) + nums[i, j]

*/
public class Solution {
    // reuse the input grid
    public int MinPathSum(int[][] grid) {
        if (grid == null || grid.Length == 0 || grid[0].Length == 0) return 0;
        // initialize the bottom array
        int m = grid.Length;
        int n = grid[0].Length;
        if (n > 1)
        {
            for (int i = n - 2; i >= 0; i--)
            {
               grid[m - 1][i] += grid[m - 1][i + 1];
            }
        }

        if (m > 1)
        {
            //Initialize the right array
            for (int i = m - 2; i >= 0; i--)
            {
                grid[i][n - 1] += grid[i + 1][n - 1];
            }
        }
        if ( m > 1 && n > 1) {
            for (int i = m - 2; i >= 0; i--)
            {
                for (int j = n - 2; j >= 0; j--)
                {
                  grid[i][j] += Math.Min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}