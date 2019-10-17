//1.记录末尾元素，向右挪元素 重复。T:O(n^k) S:O(1)
//2.借助另一个数组，先挪后面k个，再挪前面。T:O(n) S:O(n)
//3.反转
class RoutateArray {
    public void rotate(int[] nums, int k) {
        // 减少不必要循环
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}