package algorithm.LeetCode;

/**
 * describe:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _52_TotalNQueens {



//  最简要的位运算方式
  private int size;
  private int count;

  private void solve(int row, int ld, int rd) {
    if (row == size) {
      count++;
      return;
    }
    int pos = size & (~(row | ld | rd));
    while (pos != 0) {
      int p = pos & (-pos);
      pos -= p; // pos &= pos - 1; 放上皇后
      solve(row | p, (ld | p) << 1, (rd | p) >> 1);
    }
  }

  public int totalNQueens(int n) {
    count = 0;
    size = (1 << n) - 1;
    solve(0, 0, 0);
    return count;
  }


//  ================================================================

  //祥参见 官方解法
  // https://leetcode.com/problems/n-queens-ii/solution/

    //  Approach 2: Backtracking via bitmap
   public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
    /**
     row: current row to place the queen
     hills: "hill" diagonals occupation [1 = taken, 0 = free]
     next_row: free and taken slots for the next row [1 = taken, 0 = free]
     dales: "dale" diagonals occupation [1 = taken, 0 = free]
     count: number of all possible solutions
     */

    // all columns available for this board,
    // i.e. n times '1' in binary representation
    // bin(cols) = 0b1111 for n = 4, bin(cols) = 0b111 for n = 3
    // [1 = available]
    int columns = (1 << n) - 1;

    if (row == n)   // if all n queens are already placed
      count++;  // we found one more solution
    else {
      // free columns in the current row
      // ! 0 and 1 are inversed with respect to hills, next_row and dales
      // [0 = taken, 1 = free]
      int free_columns = columns & ~(hills | next_row | dales);

      // while there's still a column to place next queen
      while (free_columns != 0) {
        // the first bit '1' in a binary form of free_columns
        // on this column we will place the current queen
        int curr_column = - free_columns & free_columns;

        // place the queen
        // and exclude the column where the queen is placed
        free_columns ^= curr_column;

        count = backtrack(row + 1,
            (hills | curr_column) << 1,
            next_row | curr_column,
            (dales | curr_column) >> 1,
            count, n);
      }
    }

    return count;
  }
  public int totalNQueens2(int n) {
    return backtrack(0, 0, 0, 0, 0, n);
  }


}
