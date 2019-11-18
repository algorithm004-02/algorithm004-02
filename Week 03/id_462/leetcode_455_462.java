/**
 * 分发饼干
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        for (int i = 0,j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                ret++;
            } else {
                j++;
            }
        }
        return ret;
    }
}