class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[] sums = new int[m + 1];
        for (int i = m - 1; i > -1; i--) {
            sums[i] += grid[n - 1][i] + sums[i + 1];
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (j + 1 >= m) {
                    sums[j] = grid[i][j] + sums[j];
                } else {
                    sums[j] = grid[i][j] + Math.min(sums[j], sums[j + 1]);
                }
            }
        }
        return sums[0];
    }
}