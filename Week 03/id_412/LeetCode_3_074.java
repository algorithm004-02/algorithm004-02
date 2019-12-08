package Week03.Chapter11;

public class LeetCode_3_074 {
    // https://leetcode-cn.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        int pivotIdx, pivotEle;

        while (left <= right) {
            pivotIdx = (left + right) / 2;
            // 二维数组和一维数组的转换
            pivotEle = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotEle) {
                return true;
            } else {
                if (target < pivotEle) {
                    right = pivotIdx - 1;
                } else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        final LeetCode_3_074 test = new LeetCode_3_074();
        System.out.println(test.searchMatrix(matrix, 12));
    }
}
