// https://leetcode-cn.com/problems/move-zeroes/

// 1 count zero,
// 用一个变量zeroCounter，每次遇到一个非0元素时，就自增1.表示在这个非0元素前有多少个0，这个值就是当前元素需要往前移动的offset
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        int a = nums.length;
        for (int i = 0; i < a; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
                continue;
            }
            nums[i - zeroCounter] = nums[i];
        }
        for (int i = a - zeroCounter; i < a; i++) nums[i] = 0;
    }
}