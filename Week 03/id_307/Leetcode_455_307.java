class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int satisfied = 0;
        int gcur = 0, scur = 0;
        while (gcur < g.length && scur < s.length) {
            if (g[gcur] <= s[scur]) {
                satisfied++;
                gcur++;
                scur++;
            } else {
                scur++;
            }
        }
        return satisfied;
    }
}