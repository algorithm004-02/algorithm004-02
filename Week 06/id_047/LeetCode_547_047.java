import java.util.Arrays;

public class LeetCode_547_047 {

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private void union(int[] parent, int i, int j) {
        int xset = find(parent, i);
        int yset = find(parent, j);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
}
