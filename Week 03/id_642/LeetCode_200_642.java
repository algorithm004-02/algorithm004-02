package week3.work;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/1 07:17
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class L200 {
  /**
   * 1、找到一个'1'，就是找到了一片岛屿, num++;
   * 2、深度优先遍历把它附件所有的'1'都改成'0'
   * */
  public int numIslands(char[][] grid) {
    int num = 0;
    for (int i = 0 ; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if ('1' == grid[i][j]) {
          num++;
          dfs(i, j, grid);
        }
      }
    }
    return num;
  }

  /**
   * 递归时曾想只往右和往下，认为应该也可以，但是不行, 举个例子: [["1","1","1"],["0","1","0"],["1","1","1"]].
   * */
  public void dfs (int x, int y, char[][] grid) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || '0' == grid[x][y]) {
      return;
    }
    grid[x][y] = '0';
    dfs(x , y - 1, grid);
    dfs(x , y + 1, grid);
    dfs(x - 1 , y, grid);
    dfs(x + 1 , y, grid);
  }

  public static void main(String[] args) {
    L200 l200 = new L200();
    char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};

    // [["1","1","1"],["0","1","0"],["1","1","1"]]

    System.out.println(l200.numIslands(grid));
  }
}
