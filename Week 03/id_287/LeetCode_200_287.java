package com.tulane.mine;

/**
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3

 [["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]
 10111
 10101
 11101

 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 思考: 向下或向右相邻为1则岛屿继续延伸
 * 抽象: 把一个点的右相邻与下相邻想做是一个二叉树的左节点右节点
 * 做法: 把二维数组的所有点想象为根, 我们遍历所有的二维数组的点, 使用深度优先遍历, 记录参观过的点
 */
public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','1'},{'0','0','0','1','0'}};
        System.out.println(new NumIslands().numIslands(grid));
    }

    /**
     * 广度优先遍历
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        if(grid == null || grid.length <= 0) return num;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(!marked[row][col] && grid[row][col] == '1') {
                    num++;
                    bfs(grid, marked, row, col, dx, dy);
                }
            }
        }
        return num;
    }

    private void bfs(char[][] grid, boolean[][] marked, int row, int col, int[] dx, int[] dy) {
        Queue queue = new LinkedList();
        marked[row][col] = true;
        queue.offer(row * grid[row].length + col);
        while(!queue.isEmpty()){
            int fuc = (int) queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newCol = fuc % grid[row].length + dx[i];
                int newRow = fuc / grid[row].length + dy[i];
                if(newCol < 0 || newRow < 0 || newRow >= grid.length || newCol >= grid[newRow].length || grid[newRow][newCol] != '1' || marked[newRow][newCol]) continue;
                marked[newRow][newCol] = true;
                queue.offer(newRow * grid[newRow].length + newCol);
            }
        }
    }

    /**
     * 深度优先, 向量, 标记
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int num = 0;
        if(grid == null || grid.length <= 0) return num;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(!marked[row][col] && grid[row][col] == '1') {
                    num++;
                    _numIslands(grid, marked, row, col, dx, dy);
                }
            }
        }
        return num;
    }

    private void _numIslands(char[][] grid, boolean[][] marked, int row, int col, int[] dx, int[] dy) {
        if(marked[row][col]) return;
        marked[row][col] = true;
        for(int i = 0; i < dx.length; i++){
            int newCol = col + dx[i];
            int newRow = row + dy[i];
            if(newCol < 0 || newRow < 0 || newRow >= grid.length || newCol >= grid[newRow].length || grid[newRow][newCol] != '1') continue;
            _numIslands(grid, marked, newRow, newCol, dx, dy);
        }
    }

    /**
     * 深度优先(未看题解及讲课)
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int num = 0;
        Set<String> visited = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(!visited.contains(row + "-" + col) && grid[row][col] == '1') {
                    num++;
                    _numIslands1(grid, visited, row, col);
                }
            }
        }
        return num;
    }

    private void _numIslands1(char[][] grid, Set<String> visited, int row, int col) {
        if(visited.contains(row + "-" + col)) return;
        visited.add(row + "-" + col);
        if(col > 0 && grid[row][col-1] == '1') _numIslands1(grid, visited, row, col - 1);
        if(col < grid[row].length-1 && grid[row][col+1] == '1') _numIslands1(grid, visited, row, col + 1);
        if(row > 0 && grid[row-1][col] == '1') _numIslands1(grid, visited, row-1, col);
        if(row < grid.length - 1 && grid[row+1][col] == '1') _numIslands1(grid, visited, row+1, col);
    }
}
