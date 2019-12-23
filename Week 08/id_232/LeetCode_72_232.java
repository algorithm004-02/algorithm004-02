package src.main.java.com.fans.algorithm00402.week8.practice;

/*
* 编辑距离
* */
public class LeetCode_72_232 {

    /*
    * BFS
    * */
//    public int minDistance(String word1, String word2) {
//
//    }

    /*
     * 双端BFS
     * */
//    public int minDistance(String word1, String word2) {
//
//    }

    /*
     * 动态规划
     * */

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i ++) dp[i][0] = i;
        for (int i = 0; i <= word2.length(); i ++) dp[0][i] = i;

        for (int i = 1; i <= word1.length(); i ++) {
            for (int j = 1; j <= word2.length(); j ++) {
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);

                if (ch1 == ch2) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
