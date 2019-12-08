class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int length=matrix.length,size=matrix[0].length;
        int res=0;
        int[][] temp=new int[length+1][size+1];
        int min;
        for(int i=1;i<=length;i++){
            for(int j=1;j<=size;j++){
                if(matrix[i-1][j-1]=='1'){
                    min=Math.min(temp[i][j-1],Math.min(temp[i-1][j-1],temp[i-1][j]));
                    temp[i][j]=min+1;
                    res=res>temp[i][j]?res:temp[i][j];
                }
            }
        }
        return res*res;
    }
}

在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。