/* 
* 题号: 74
* 题目: 搜索二维矩阵
* 地址: https://leetcode-cn.com/problems/search-a-2d-matrix/
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        if(i == 0) return false;
        int j = matrix[0].length;
        int left = 0;
        int right = i * j - 1;
        int mid,midEle;
        while(left <= right){
            mid = (left + right) / 2;
            midEle = matrix[mid / j][mid % j];
            if(target == midEle){
                return true;
            }else {
                if(target > midEle){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
