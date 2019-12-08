package week6;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/22 07:31
 *  https://leetcode-cn.com/problems/friend-circles
 *  朋友圈问题
 */
public class L547 {
  private int count;
  private int[] parent;

  /**
   * 使用并查集来解决.
   * @param M
   * @return
   */
  public int findCircleNum(int[][] M) {
    count = M.length;
    parent = new int[M.length];
    for (int i = 0; i < M.length; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M.length; j++) {
        if (M[i][j] == 1) {
          union(i, j);
        }
      }
    }
    return count;
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    parent[rootP] = rootQ;
    count--;
  }

  public int find(int p) {
    while (p != parent[p]) {
      // 路径压缩
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }
}
