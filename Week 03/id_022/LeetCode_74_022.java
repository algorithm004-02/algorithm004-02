//[74]搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null) return false;

        int row = matrix.length;
        if (row == 0) return false;

        int col = matrix[0].length;
        if (col == 0) return false;

        int left = 0, right = row * col - 1;
        while (left <= right) {
            int p = (left + right) / 2;
            int n = matrix[p / col][p % col];
            if (n == target) {
                return true;
            } else if (target < n) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result;
        SearchA2dMatrix solution = new SearchA2dMatrix();

        result = solution.searchMatrix(new int[0][0], 1);
        System.out.println(result);
        if (result) {
            throw new AssertionError("case1");
        }

        result = solution.searchMatrix(new int[][]{new int[0]}, 1);
        System.out.println(result);
        if (result) {
            throw new AssertionError("case2");
        }

        result = solution.searchMatrix(new int[][]{new int[]{1}}, 1);
        System.out.println(result);
        if (!result) {
            throw new AssertionError("case3");
        }

        result = solution.searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}}, 3);
        System.out.println(result);
        if (!result) {
            throw new AssertionError("case4");
        }

        result = solution.searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}}, 13);
        System.out.println(result);
        if (result) {
            throw new AssertionError("case5");
        }

    }
}