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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                    numIslands += dfs(grid, i, j);
            }
        }
        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        // 1. row < 0
        // 2. row greater than grid.length
        // 3. column < 0
        // 4. column greater than grid.length
        // 5. if the position is a '0'
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;

        grid[i][j] = '0'; // chagne the visited land to water
        dfs(grid, i + 1, j); // up
        dfs(grid, i - 1, j); // down
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
