package src.main.java.com.fans.algorithm00402.week3.homework;

/**
 * 搜索二维矩阵
 */
public class LeetCode_74_232 {

    /**
     * 1. 行内二分搜索
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) return false;
//        // 优先找到对应的行
//        int row = 0;
//        for (; row < matrix.length; row ++) {
//            if (matrix[row][0] > target) {
//                break;
//            }
//        }
//        if (row > 0) row --;
//
//        // 二分查找
//        int left = 0;
//        int right = matrix[row].length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (matrix[row][mid] > target) {
//                right = mid - 1;
//            } else if (matrix[row][mid] < target){
//                left = mid + 1;
//            } else {
//                return true;
//            }
//        }
//
//        return false;
//    }

    /**
     * 2. 双二分查找
     *  - 首先行进行二分搜索
     *  - 再行内进行二分查找
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) return false;
//
//        int up = 0;
//        int down = matrix.length - 1;
//        int row = -1;
//        while (up <= down) {
//            int mid = up + (down - up) / 2;
//            if (target > matrix[mid][matrix[mid].length - 1]) {
//                up = mid + 1;
//            } else if (target < matrix[mid][0]) {
//                down = mid - 1;
//            } else {
//                row = mid;
//                break;
//            }
//        }
//        if (row < 0) return false;
//        int left = 0;
//        int right = matrix[row].length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (target > matrix[row][mid]) {
//                left = mid + 1;
//            } else if (target < matrix[row][mid]) {
//                right = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 3. 从右上角开始
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix == null || matrix.length == 0)
//            return false;
//
//        int row = 0;
//        int col = matrix[0].length - 1;
//        while (row < matrix.length && col >= 0) {
//            if (matrix[row][col] > target) col --;
//            else if (matrix[row][col] < target) row ++;
//            else return true;
//        }
//        return false;
//    }

    /**
     * 4. 当做1维数组进行二分
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_74_232 code = new LeetCode_74_232();
        int[][] matix = {{1, 1}};
        System.out.println(code.searchMatrix(matix, 2));
    }
}
