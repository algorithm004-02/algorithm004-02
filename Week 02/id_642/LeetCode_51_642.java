package week2.work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/27 11:38
 *
 * https://leetcode-cn.com/problems/n-queens/
 */
public class L51 {

  private Set<Integer> colSet = new HashSet<>();
  private Set<Integer> left = new HashSet<>();
  private Set<Integer> right = new HashSet<>();
  private List<List<Integer>> retList = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    subSolveNQuees(n, 0, new ArrayList<>());
    return print(retList, n);
  }

  /**
   * 回溯.
   * */
  public void subSolveNQuees(int n, int row, List<Integer> list) {
    if (row >= n) {
      retList.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < n ; i++) {
      if (colSet.contains(i) || left.contains(row - i) || right.contains(row + i)) {
        continue;
      }
      list.add(i);
      colSet.add(i);
      left.add(row - i);
      right.add(row + i);
      // 递归
      subSolveNQuees(n ,row + 1, list);
      // 清理
      list.remove(list.size() - 1);
      colSet.remove(i);
      left.remove(row - i);
      right.remove(row + i);
    }
  }

  public List<List<String>> print(List<List<Integer>> retList, int n) {
    List<List<String>> psList = new ArrayList<>();
    /** 每一种结果都遍历生成结果字符串 */
    for (int i = 0; i < retList.size(); i++) {
      List<String> sList = new ArrayList<>();
      List<Integer> rList = retList.get(i);
      for (int j = 0; j < n; j++) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < n; k++) {
          if (k == rList.get(j)) {
            stringBuilder.append("Q");
          } else {
            stringBuilder.append(".");
          }
        }
        sList.add(stringBuilder.toString());
      }
      psList.add(sList);
    }
    return psList;
  }

  public static void main(String[] args) {
    L51 l51 = new L51();
    System.out.println(l51.solveNQueens(4));
  }
}
