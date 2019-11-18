/**
 * 搜索二维矩阵
 * Created by yangwenwei on 2019/11/1.
 */
public class LeetCode_74_597 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            int lo = 0, hi = matrix.length * matrix[0].length - 1;
            while (lo <= hi) {
                int mid = lo + ((hi - lo) >> 1), i = mid / matrix[0].length, j = mid % matrix[0].length;
                if (matrix[i][j] == target) return true;
                if (matrix[i][j] > target) hi = mid - 1;
                else lo = mid + 1;
            }
            return false;
        }
    }
}
