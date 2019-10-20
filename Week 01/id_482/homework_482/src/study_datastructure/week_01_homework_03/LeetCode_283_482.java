package study_datastructure.week_01_homework_03;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/17
 * @link https://leetcode-cn.com/problems/move-zeroes/
 * 直接在leetcode上进行测试
 */
public class LeetCode_283_482 {

    /**
     * 解法一：
     * 遍历数组，用一个下标（指针）存放非0元素，把非零元素向前移动，0向后移动
     * 思路分析：
     */
    public void moveZeroes_1(int[] nums) {
       int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j]=nums[i];
                if (j !=i ) {
                    nums[i]=0;
                }
                j++;
            }
        }
    }

    /**
     * 解法2：
     * 记录非0个数(既是个数，也是索引)，遍历数组 把非0元素向前挪动，再补0
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {

        int notZeroAt=0;

        for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) {
               nums[notZeroAt++]=nums[i];
           }
        }

        for (int i =notZeroAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 解法3：
     * 记录非0个数,把 0 和非0 进行交换 ,实际上和解法一 是一样的；
     * @param nums
     */
    public void moveZeroes_3(int[] nums) {
        for (int i = 0,j=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp=nums[j];//指代 上一次被赋值的非0元素的 的下一位
                nums[j]=nums[i];
                nums[i]=tmp;
                j++;
            }
        }
    }




}
