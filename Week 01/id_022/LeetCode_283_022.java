//[283]移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

import java.util.Arrays;

public class MoveZeroes {

    /**
     * 双指针/快慢指针
     * <p>
     * 快指针指向第一个非0，慢指针指向第一个0，交换两个指针的值
     *
     * @param nums
     */
    public void move1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        int[] case1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes.move1(case1);
        if (!Arrays.equals(case1, new int[]{1, 3, 12, 0, 0})) {
            throw new AssertionError("case1");
        }

        int[] case2 = new int[]{0};
        moveZeroes.move1(case2);
        if (!Arrays.equals(case2, new int[]{0})) {
            throw new AssertionError("case2");
        }

        int[] case3 = new int[0];
        moveZeroes.move1(case3);
        if (!Arrays.equals(case3, new int[0])) {
            throw new AssertionError("case3");
        }
    }
}