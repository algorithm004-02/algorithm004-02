class Solution {
    public int minPathSum(int[][] grid) {

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {

                //下面没有元素
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];

                    //右面没有元素
                } else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];


                    //选择下一步  向下或者向右的两个元素中最小的
                } else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }

}
