import java.util.Arrays;

/**
 * 分发饼干
 * Created by yangwenwei on 2019/10/29.
 */
public class LeetCode_455_597 {
    class Solution {

        //贪心算法
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int gi = 0, si = 0, res = 0;
            while (gi < g.length && si < s.length) {
                if (s[si] >= g[gi]) {
                    res++;
                    si++;
                    gi++;
                } else si++;
            }
            return res;
        }
    }
}
