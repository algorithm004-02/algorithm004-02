package com.arithmetic.arithmetic.week03;

public class LeetCode_200_657 {

    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean[][] marked;

    private int rows;

    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }


    private void dfs(int i, int j) {
        marked[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];

            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }


    private boolean inArea(int x, int y) {

        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
