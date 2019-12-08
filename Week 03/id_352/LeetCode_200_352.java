/**
 * @(#)NumberOfIsland.java, Nov 03, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author helloliu
 */

/**
 * //给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 *深度优先搜索：遍历二维数组的每一个元素，计算出当前元素所连接的陆地，因为陆地可能是连续的，
 * 因此在以某一点向外深度遍历的时候，要将遍历过的元素置成非陆地状态，避免重复计算
 */
public class NumberOfIsland {
    private int x;
    private int y;

    public int numIslands(char[][] grid) {
        int IslandCount = 0;
        if (grid == null) {
            return 0;
        }
        y = grid.length;
        if (y == 0) {
            return 0;
        }
        x = grid[0].length;

        for (int i = 0; i < y; y++) {

            for (int j = 0; j < x; j++) {

                if (grid[i][j] == '1') {
                    //以当前节点为起点，遍历
                    dfs(grid, i, j);
                    IslandCount++;
                }
            }
        }
        return IslandCount;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= y || j >= x || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        //将当前节点置0
        grid[i][j] = '0';
        //分别遍历四个方向
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

    }

}