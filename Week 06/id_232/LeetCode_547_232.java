package src.main.java.com.fans.algorithm00402.week6.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 朋友圈
 */

public class LeetCode_547_232 {

    /**
     * DFS
     */
//    public int findCircleNum(int[][] M) {
//        int count = 0 ,n = M.length;
//        int[] cache = new int[n];
//        for (int i = 0; i < n; i ++) {
//            if (cache[i] == 0) {
//                count ++;
//                dfs(M, i, cache);
//            }
//        }
//        return count;
//    }
//
//    private void dfs(int[][] M ,int i, int[] cache) {
//        for (int j = 0; j < M.length; j ++) {
//            if (M[i][j] == 1 && cache[j] == 0) {
//                cache[j] = 1;
//                dfs(M, j, cache);
//            }
//        }
//    }

    /**
     * BFS
     */
//    public int findCircleNum(int[][] M) {
//        int count = 0 ,n = M.length;
//        int[] cache = new int[n];
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i ++) {
//            if (cache[i] == 0) {
//                queue.add(i);
//                while (!queue.isEmpty()) {
//                    int l = queue.poll();
//                    cache[l] = 1;
//                    for (int j = 0; j < n; j ++) {
//                        if (M[l][j] == 1 && cache[j] == 0)
//                            queue.add(j);
//                    }
//                }
//                count ++;
//            }
//        }
//        return count;
//    }

    /**
     * 并查集
     */
    public int findCircleNum(int[][] M) {

        DisjoinSet set = new DisjoinSet(M.length);
        for (int i = 0; i < M.length; i ++) {
            for (int j = 0; j < M.length; j ++) {

                if (M[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }
        return set.size;
    }

    private class DisjoinSet {
        int size;
        private int[] parents;
        public DisjoinSet(int n) {
            size = n;
            parents = new int[n];
            for (int i = 0; i < n; i ++) {
                parents[i] = i;
            }
        }

        public int find(int f) {
            while (f != parents[f]) {
                // 路径压缩
                parents[f] = parents[parents[f]];
                f = parents[f];
            }
            return f;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parents[rootQ] = rootP;
            size --;
        }
    }
}
