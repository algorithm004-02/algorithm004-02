package algorithm.LeetCode;

/**
 * describe:
 *
 作者：LeetCode
 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
 * @author lixilong
 * @date 2019/11/03
 */
public class _74_SearchMatrix {


  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;

    // 二分查找
    // 注意到输入的 m x n 矩阵可以视为长度为 m x n的有序数组。
    // 虚数组 和 二位矩阵的转换
    // row = idx // n ， col = idx % n。


    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
      pivotIdx = (left + right) / 2;
      pivotElement = matrix[pivotIdx / n][pivotIdx % n];
      if (target == pivotElement) return true;
      else {
        if (target < pivotElement) right = pivotIdx - 1; //有序找值用二分查找
        else left = pivotIdx + 1;
      }
    }

    return false;
  }


}
