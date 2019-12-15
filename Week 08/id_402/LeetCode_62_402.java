class Solution {
    public int uniquePaths(int m, int n) {//继续过遍数  
        //递推方程
        // p[i][] = 1  p[][j] = 1
        // p[i][j] = p[i-1][j] + p[i-1][j-1]
        int[] statusArr = new int[m];
        Arrays.fill(statusArr, 1);
        for (int i = 0; i < n - 1; i++) {
            for (int j = m - 2; j >= 0; j --) {
                statusArr[j] += statusArr[j + 1];
            }
        }
        return statusArr[0];
    }
}