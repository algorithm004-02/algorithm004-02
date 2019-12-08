//[200]岛屿数量
//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


public class NumberOfIslands {

    /**
     * flood fill
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                n += flood(i, j, grid);
            }
        }

        return n;
    }

    private int flood(int i, int j, char[][] grid) {
        if (i < 0 || j < 0
                || i >= grid.length || j >= grid[i].length
                || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        flood(i - 1, j, grid);
        flood(i + 1, j, grid);
        flood(i, j - 1, grid);
        flood(i, j + 1, grid);

        return 1;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] case1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int result = solution.numIslands(case1);
        System.out.println(result);
        if (result != 1) {
            throw new AssertionError("case1");
        }

        char[][] case2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        result = solution.numIslands(case2);
        System.out.println(result);
        if (result != 3) {
            throw new AssertionError("case1");
        }

        char[][] case3 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        result = solution.numIslands(case3);
        System.out.println(result);
        if (result != 1) {
            throw new AssertionError("case1");
        }
    }

}