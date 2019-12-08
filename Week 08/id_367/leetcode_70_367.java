//更改部分代码
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int [][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++) dp[i][0] = i;
        for(int j = 0; j <= n2; j++) dp[0][j] = j;
        for(int i = 1; i <= n1; i++)
            for(int j = 1; j <= n2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] =Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])  + 1;
            } 
        return dp[n1][n2];
    }
}
//powcai 的题解
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];  
    }
}

//4ms的题解
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] memo = new int[len1][len2];
        return minDistance(word1, word2, len1 - 1, len2 - 1, memo);
    }

    private int minDistance(String word1, String word2, int i, int j, int[][] memo) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (memo[i][j] != 0) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = minDistance(word1, word2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.min(minDistance(word1, word2, i - 1, j - 1, memo) + 1,
                    Math.min(minDistance(word1, word2, i, j - 1, memo) + 1, minDistance(word1, word2, i - 1, j, memo) + 1));
        }
        return memo[i][j];
    }
}


