package src.main.java.com.fans.algorithm00402.week3.homework;

import java.util.Arrays;

/**
 * 分发饼干
 */
class LeetCode_455_232 {

    /**
     * 1. 贪心算法
     *  - 只用当前最小的饼干喂最小胃口的孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int i = 0, j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count ++;
                i ++;
                j ++;
            } else {
                j ++;
            }
        }
        return count;
    }
}
