class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        
        //Don't forget null check
        
        if ( m == 0) {
            return false;
        }
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n -1;//U must start from 0 to m * n -1, not 1 to m * n, otherwise matrix will be out of bound
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = matrix[mid/n][mid%n];
            
            if (midElement == target) {
                return true;
            } else if ( midElement >  target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
            
        }
        
        return false;
        
    }
    
   /* public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            
            return false;
        }*/
}