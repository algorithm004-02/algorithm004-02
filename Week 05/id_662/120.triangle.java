/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] nums = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                nums[j] = Math.min(nums[j], nums[j + 1]) + triangle.get(i).get(j);
            }
        }
        return nums[0];
    }
}