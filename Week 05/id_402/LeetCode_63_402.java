class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] statusArr = new int[obstacleGrid[0].length];
        statusArr[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j  < statusArr.length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    statusArr[j] = 0;
                }
                else if (j > 0) {
                    statusArr[j] += statusArr[j - 1];
                }
            }
        }
        return statusArr[statusArr.length - 1];
    }
}