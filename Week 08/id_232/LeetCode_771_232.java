package src.main.java.com.fans.algorithm00402.week8.practice;

/**
 * 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class LeetCode_771_232 {

    /**
     * 暴力法
     */
    public int numJewelsInStones(String J, String S) {
        char[] charsJ = J.toCharArray();
        char[] charsS = S.toCharArray();

        int count = 0;

        for (int i = 0; i < charsJ.length; i ++) {
            for (int j = 0; j < charsS.length; j ++) {
                if (charsJ[i] == charsS[j]) count ++;
            }
        }

        return count;
    }
}
