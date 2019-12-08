class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        if(col == 0) return 0;
        int[][] rectangle = new int[row][col];
        for(int i = 0 ; i<row ;  i++) {
            for(int j = 0 ; j<col ; j++) {
                int area = matrix[i][j];
                if(i>0) {
                    area += rectangle[i-1][j];
                }
                if(j>0) {
                    area += rectangle[i][j-1];
                }
                //减去重复计算的面积
                if(i>0 && j>0) {
                    area -= rectangle[i-1][j-1];
                }
                
                rectangle[i][j] = area;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int startRow = 0 ; startRow<row; startRow++) {//矩形的起点行
            for(int endRow = startRow ; endRow<row ; endRow++) {//矩形的结束行
                for(int startCol = 0 ; startCol<col ; startCol++) {//矩形的起始列
                    for(int endCol = startCol ; endCol<col ; endCol++) {//矩形的结束列
                        int area = rectangle[endRow][endCol];
                        if(startRow > 0) {
                            area -= rectangle[startRow-1][endCol];
                        }
                        if(startCol > 0) {
                            area -= rectangle[endRow][startCol-1];
                        }
                        if(startRow > 0 && startCol > 0) {
                            area += rectangle[startRow-1][startCol-1];
                        }
                        if (area <= k)
                            result = Math.max(result, area);
                    }
                }
            }
        }
        return result;
    }
    
    
}


给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。