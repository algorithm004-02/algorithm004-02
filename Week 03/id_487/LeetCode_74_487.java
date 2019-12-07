class LeetCode_74_487{

    /***
     *
     * 74题
     *
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值
     *
     * 题解：第一层for循环先找出target所在的行（和所在行最后一个进行比较）
     *      第二次用二分法查找所在行的具体值
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0||matrix[0].length == 0) {
            return false;
        }

        int targetI = 0;
        int targetJ = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] number = matrix[i];
            if (target <=  number[number.length-1]) {
                targetI = i;
                break;
            } else {
                continue;
            }
        }

        int left = 0;
        int right = matrix[targetI].length - 1;
        int[] matrix2 = matrix[targetI];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix2[mid] == target) {
                return true;
            } else if (matrix2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}