//[189]旋转数组
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


import java.util.Arrays;

public class RotateArray {

    /**
     * 环形替换法
     * <p>
     * 1. 需要注意 nums.lenght % k == 0 的情况
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k % nums.length == 0) {
            return;
        }

        int step = 0;
        for (int i = 0; step < nums.length; i++) {
            int curr = i;
            int n = nums[curr];
            do {
                int to = (curr + k) % nums.length;
                int temp = nums[to];
                nums[to] = n;
                n = temp;
                curr = to;
                step++;
            } while (curr != i);
        }
    }

    public static void main(String[] args) {

        RotateArray rotateArray = new RotateArray();

        int[] case1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate1(case1, 3);
        if (!Arrays.equals(case1, new int[]{5, 6, 7, 1, 2, 3, 4})) {
            throw new AssertionError("case1");
        }

        int[] case2 = new int[]{1, 2, 3, 4, 5, 6};
        rotateArray.rotate1(case2, 2);
        if (!Arrays.equals(case2, new int[]{5, 6, 1, 2, 3, 4})) {
            throw new AssertionError("case2");
        }

        int[] case3 = new int[0];
        rotateArray.rotate1(case3, 2);
        if (!Arrays.equals(case3, new int[0])) {
            throw new AssertionError("case3");
        }

    }
}