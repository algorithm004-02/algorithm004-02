 /**
     * https://leetcode-cn.com/problems/unique-paths/
     * 62. 不同路径
     *
     * @param m m
     * @param n n
     * @return 路径
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];

        // init
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            nums[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i][j - 1] + nums[i - 1][j];

            }
        }
        return nums[m - 1][n - 1];
    }