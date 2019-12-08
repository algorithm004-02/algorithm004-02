package main.java.com.fans.algorithm00402.week1.homework;

/**
 * 【移动零】
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LeetCode_283_232 {

    // 1. 双指针法：非0元素全部移到数组前面， 后面全部置0   时：O(n)  空：O(1)
//    public void moveZeroes(int[] nums) {
//        int index = 0;
//        for (int i = 0; i < nums.length ; i ++) {
//            if (nums[i] != 0) {
//                nums[index] = nums[i];
//                if (index != i) {
//                    nums[i] = 0;
//                }
//                index ++;
//            }
//        }
//    }

    // 2. 使用数组保存非0元素， 然后复制回原数组  时：O(n)  空：O(n)
    public void moveZeroes(int[] nums) {
        int[] a = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                a[index ++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = a[i];
        }
    }
}
