Thinking:
使用二分查找的思想，通过对两边极端值得判断，决定之后的查找顺序。两边夹逼的方法

Code:

class Solution {//大神代码  关键分析，需要理清楚所有边界条件
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {//使用异或判断，聪明的回避复杂的if else 判断。
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start == end && nums[start] == target? start : -1;// 若找到最终间的节点，并且等于target时，返回角标。
    }
}