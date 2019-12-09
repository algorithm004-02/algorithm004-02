package Week08;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Solution72 {

    //自顶向下
    public int minDistance(String word1, String word2) {

        /** dp状态 从word1的第i位变到word2的第j位 */

        int row = word1.length();
        int column = word2.length();

        //从‘’开始, dp[1][1]到dp[len1+1][len2+1]
        int[][] dp = new int[row+1][column+1];

        //初始化[0][j]、[i][0]
        for(int i=1; i<=row; i++){
            //第一列
            dp[i][0] = dp[i-1][0] + 1;
        }

        for(int j=1; j<=column; j++){
            //第一行
            dp[0][j] = dp[0][j-1] + 1;
        }

        //其他行列
        for(int i=1; i<=row; i++)
            for(int j=1; j<=column; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {

                    //替换、删除、插入
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }

        return dp[row][column];
    }
}
