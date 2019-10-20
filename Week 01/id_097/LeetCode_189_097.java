
public class Solution {

    public void rotate(int[] nums, int k) {

        // 超过一圈的情况
        k = k % nums.length;

        _reverse(nums, 0, k - 1);
        _reverse(nums, k, nums.length - 1);
        _reverse(nums, 0, nums.length - 1);

    }

    // 翻转
    private void _reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
