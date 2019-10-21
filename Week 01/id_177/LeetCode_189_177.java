package week01;

/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:

    输入: [-1,-100,3,99] 和 k = 2
    输出: [3,99,-1,-100]
    解释:
    向右旋转 1 步: [99,-1,-100,3]
    向右旋转 2 步: [3,99,-1,-100]

说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import java.util.Arrays;

public class LeetCode_189_177 {

    public static void main(String[] args) {
        LeetCode_189_177 test = new LeetCode_189_177();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
        int k = 14;
        test.rotate(nums, k);

        System.out.println("nums: " + Arrays.toString(nums));

    }

//    1. 暴力：时间复杂度：O(n * k)
//    private void rotate(int[] nums, int k) {
//        int temp;
//        for (int i = 0; i < k; i++) {
//            temp = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = temp;
//        }
//    }

    // 2. 使用反转：时间复杂度：O(n) + O(k) + O(n-k)
    private void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    // 反转：双指针双向逼近
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}