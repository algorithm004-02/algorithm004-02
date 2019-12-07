/**
 * 在有序旋转数组中搜索每个值
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 2);
            if (target == nums[mid]) {
                return mid;
            }else if (nums[mid] >= nums[begin]) {
                //before
                if (target >= nums[begin] && target <= nums[mid]) {
                    end = end - 1;
                    //back
                }else {
                    begin = mid + 1;
                }
            }else if (nums[mid] < nums[begin]) {
                if (target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                }else {
                    end = end - 1;
                }
            }
        }
        return -1;
    }
}