package datastruct.MethodOfBisectio;

/**
 * 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     每行中的整数从左到右按升序排列。
     每行的第一个整数大于前一行的最后一个整数。
     示例 1：
     输入:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 3
     输出: true


     示例 2:
     输入:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 13
     输出: false
 */
public class SearchA2dMatrix {

    /**
     * 方法：二分查找
        直觉
        注意到输入的 m x n 矩阵可以视为长度为 m x n的有序数组。

        由于该 虚 数组的序号可以由下式方便地转化为原矩阵中的行和列 (我们当然不会真的创建一个新数组) ，该有序数组非常适合二分查找。
        row = idx // n ， col = idx % n

     算法
        这是一个标准二分查找算法 :
        初始化左右序号
        left = 0 和 right = m x n - 1。
        While left < right :
            选取虚数组最中间的序号作为中间序号: pivot_idx = (left + right) / 2。
            该序号对应于原矩阵中的 row = pivot_idx // n行 col = pivot_idx % n 列,
            由此可以拿到中间元素pivot_element。该元素将虚数组分为两部分。
            比较 pivot_element 与 target 以确定在哪一部分进行进一步查找。。
        时间复杂度 : 由于是标准的二分查找，时间复杂度为O(\log(m n))O(log(mn))。
        空间复杂度 : O(1)O(1)。
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return  false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0,right = m * n - 1;
        int pivotIdx,pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return  true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    /**
     * 方法2
     *
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return  false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int l = 0,r = m * n - 1;
        while (l != r) {
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }

}
