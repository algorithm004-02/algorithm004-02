package com.itliusir.bfs;

/**
 * problem.200
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 *
 * @author liugang
 * @date 2019-11-03
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    /**
     * method 1 -> time O()
     * @author liugang
     * @date 2019-11-03 22:14:33
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    doNumIslands(grid, i, j, m, n);
                    ++count;
                }
            }
        }
        return count;
    }

    private void doNumIslands(char[][] grid, int i, int j, int m, int n) {
        // terminator
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        // process mark islandsIndex = 0
        grid[i][j] = '0';
        // drill down
        doNumIslands(grid, i + 1, j, m, n);
        doNumIslands(grid, i - 1, j, m, n);
        doNumIslands(grid, i, j + 1, m, n);
        doNumIslands(grid, i, j - 1, m, n);
    }
}
