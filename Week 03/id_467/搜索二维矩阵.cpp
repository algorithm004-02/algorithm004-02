//先二分找到target所在行，再二分找到target，代码比转成一维数组稍多，写了两次二分。
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0) return false;
        if (matrix[0].size() == 0) return false;
        int high = 0, low = matrix.size() - 1, left = 0, n, right;
        n = right = matrix[0].size() - 1;
        while (high <= low) {
            int lmid = high + (low - high) / 2;
            if (matrix[lmid][0] == target) {
                return true;
            } else if (matrix[lmid][0] > target) {
                low = lmid - 1;
            } else if (matrix[lmid][0] < target && matrix[lmid][n] < target) {
                high = lmid + 1;
            } else {
                int mid;
                while (left <= right) {
                    mid = left + (right - left) / 2;
                    if (matrix[lmid][mid] == target) { 
                        return true;
                    } else if (matrix[lmid][mid] > target) {
                        right = mid -1;
                    } else {
                        left = mid + 1;
                    }
                }
                return matrix[lmid][left] == target;
            }
        }
        return false;
    }
};


//把二维数组转成一维数组版
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0){
            return false;
        }
        int rows = matrix.size(); 
        int cols = matrix[0].size();
        int left = 0, right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;      
    }
};