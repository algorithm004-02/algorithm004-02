在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4

class Solution {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j]为由1组成的最大正方形边长，
        //dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;  
        int [][] dp = new int [row+1][col+1];
        int maxsqlen = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    maxsqlen = Math.max(dp[i][j],maxsqlen);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}