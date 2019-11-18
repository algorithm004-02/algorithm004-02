package com.study.week3.lesson9;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/30
 * @link
 */
public class LeetCode_200_482 {

    /**
     * 深度优先搜索
     * @param
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int height=grid.length;
        int width=grid[0].length;
        int numIslands=0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    ++numIslands;
                    dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int height=grid.length;
        int width=grid[0].length;

        if (i<0 || j<0 || i>=height || j>= width || grid[i][j] == '0')
            return;

        grid[i][j]=0;
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);

    }

    public static void main(String[] args) {
        char [][] test={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        new LeetCode_200_482().numIslands(test);
    }


}
