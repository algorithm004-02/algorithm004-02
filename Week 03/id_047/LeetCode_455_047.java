import java.util.Arrays;

public class LeetCode_455_047 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int currS = -1;
        for (int i = 0; i < g.length; i++) {
            for (int j = currS + 1; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    count++;
                    currS = j;
                    break;
                }
            }
        }
        return count;
    }
}
