// https://leetcode-cn.com/problems/rotate-array/
// 新建一个临时数组，时间复杂度O(N),空间复杂度O（N）
class Solution {
    public void rotate(int[] nums, int k) {
        int a = nums.length;
        if (a == 0) return;
        int[] temp = new int[nums.length];
        for (int i = 0; i< a; i++) {
            temp[(i + k) % a] = nums[i];
        }
        for (int i = 0; i < a; i++) {
            nums[i] = temp[i];
        }
    }
}