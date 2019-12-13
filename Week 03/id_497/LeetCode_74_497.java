class Solution {
    int length;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        length =  matrix[0].length;
        int index = binarySearchArray(matrix,target);
        if(index == -1) return false;
        return  binarySearch(matrix[index],target,0,length)>-1?true:false;
    }

    private int binarySearchArray(int[][] matrix,int target) {
        int left = 0, right = matrix.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right)+1/ 2;
            if(mid == 0) return 0;
            if (target <= matrix[mid][length-1] &&  target > matrix[mid - 1][length-1] ) {
                return mid;
            } else if (target> matrix[mid][length-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private int binarySearch(int[] nums,int target,int start,int end) {
        int left = start, right = end-1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}