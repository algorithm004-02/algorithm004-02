/**
 * leetcode 求旋转数组中的最小值
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length ==0) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = begin +((end - begin) >> 2);
            if (nums[mid] < nums[end]) {
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return nums[begin];
    }
}