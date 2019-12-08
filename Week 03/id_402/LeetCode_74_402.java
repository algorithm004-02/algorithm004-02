class Solution {//二分查找，上升到二维数组层面。首先纵向二查排序，找到所属行项目后进行二叉查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix.length == 0 ? 0 : matrix[0].length;
        int start = 0, end = m * n - 1,mid;
        while (start <= end) {
            //找到一位数组的坐标
            int midIndex = (start + end) / 2;
            //转化为二维数组的元素
            if (target == matrix[midIndex / n][midIndex % n]) {
                return true;
            } else if (target < matrix[midIndex/n][midIndex % n]) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return false;
    }
}