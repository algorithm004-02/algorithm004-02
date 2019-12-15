package week5;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/16 17:44
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class L64 {
  /**
   * dp公式: f(i, j) = Min(grid[i][j] + f(i-1, j), grid[i][j] + f(i)(j-1))
   * 空间复杂度: 在原数组操作，不需要额外的空间
   * */
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += grid[0][i];
      grid[0][i] = sum;
    }
    sum = 0;
    for (int i = 0; i < m; i++) {
      sum += grid[i][0];
      grid[i][0] = sum;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] = Math.min(grid[i][j] + grid[i-1][j], grid[i][j] + grid[i][j-1]);
      }
    }
    return grid[m-1][n-1];
  }
}
