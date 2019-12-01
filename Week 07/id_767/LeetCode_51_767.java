package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * describe:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * N 皇后 剪枝法
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _51_SolveNQueens {

 // Runtime: 3 ms, faster than 97.00%
  public List<List<String>> solveNQueens(int n) {
    boolean[] cols = new boolean[n];
    boolean[] d1 = new boolean[n * 2];
    boolean[] d2 = new boolean[n * 2];
    int[] qs = new int[n];
    List<List<String>> res = new ArrayList();
    helper(0, res, qs, cols, d1, d2, n);
    return res;
  }
  public void helper(int row, List<List<String>> res, int[] qs, boolean[] cols, boolean[] d1, boolean[]d2, int n){
    if(row == n){
      List<String> sub = new ArrayList();
      for(int i = 0; i < n; i++){
        char[] ch = new char[n];
        Arrays.fill(ch,'.');
        ch[qs[i]] = 'Q';
        sub.add(new String(ch));
      }
      res.add(sub);
      return;
    }
    for(int i = 0; i < n; i++){
      int id1 = i - row + n;
      int id2 = i + row;
      if(cols[i] || d1[id1] || d2[id2]) continue;
      cols[i] = true;
      d1[id1] = true;
      d2[id2] = true;
      qs[row] = i;
      helper(row+1, res, qs, cols, d1, d2, n);
      cols[i] = false;
      d1[id1] = false;
      d2[id2] = false;
    }
  }

/*
  //方法2：Runtime: 18 ms, faster than 12.32%
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList();
    Deque<List<Integer>> queue = new LinkedList();
    queue.offer(new ArrayList());

    while(!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        List<Integer> cols = queue.poll();
        if (cols.size() == n) {
          result.add(drawChessboard(cols));
        } else {
          for (int col = 0; col < n; col++) {
            if (isValid(cols, cols.size(), col)) {
              List<Integer> newCols = new ArrayList<>(cols);
              newCols.add(col);
              queue.offer(newCols);
            }
          }
        }
        size--;
      }
    }
    return result;
  }

  private boolean isValid(List<Integer> cols, int i, int j) {
    for (int r = 0; r < cols.size(); r++) {
      int a = Math.abs(i - r);
      int b = Math.abs(j - cols.get(r));
      if (a == b || a == 0 || b == 0) {
        return false;
      }
    }
    return true;
  }

  private List<String> drawChessboard(List<Integer> cols) {
    List<String> chessboard = new ArrayList<>();
    for (int i = 0; i < cols.size(); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols.size(); j++) {
        sb.append(j == cols.get(i) ? 'Q' : '.');
      }
      chessboard.add(sb.toString());
    }
    return chessboard;
  }*/

}
