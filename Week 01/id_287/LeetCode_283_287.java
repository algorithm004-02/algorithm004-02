package com.tulane.homework;

/**
 * @title https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class LeetCode_283_287 {

    /**
     * 三刷: 双指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0){
                continue;
            }
            if(i != j) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            //每次不为0, 指针都需移动
            i++;
        }
    }


    /**
     * 第四种: 网上的例子, 与我的第二种理念相同却简单数倍, 并将指针交换转换为步长移动
     * 记录i指针前面共有多少0, 并依此跨步移动, 最终末尾补足0即可
     * @param nums
     */
    public void moveZeroes4(int[] nums) {
        //[0,1,0,3,12]
        int sizeNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sizeNum++;
            } else {
                nums[i - sizeNum] = nums[i];
            }
        }
        for (int i = 0; i < sizeNum; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    /**
     * 第三种: 双指针, i指针从下标0开始扫描数组, j指针从下标0开始, 填入值
     * j指针填入的值为i扫描到的非零值, i位置再覆盖0值, 相当于swap交换数值
     * 最终达到非零数值依次迁移至j指针扫描路径, 相当于重新创建数组.
     * <p>
     * 注意点: 扫描时, 若i指针与j指针处于同一下标, 则不进行swap交换, 因为
     * 程序为节省内存, 未创建交换所需临时变量, 采用取巧方法, 即后者直接置为0
     * 所以交换会导致当前非零数变为0
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        // [0, 1, 0, 2, 4]
        // 利用指针, 在原数组中重新创建数组, 指针从下标0位置开始, 每次移动代表有非0的数插入
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                continue;
            }
            if (i != j) {
                nums[j] = nums[i];
                nums[i] = 0;
            }
            j++;
        }
    }

    /**
     * 第二种, 遇到0进入二层循环, 二层循环遇至0跳出循环, 修改一层循环指针i, 二层循环会将数值向前移动
     * 保证循环只有一遍, 逻辑复杂边界不好控制
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        int i = 0;
        int zeroNum = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                if ((i + 1) >= nums.length) {
                    break;
                }
                int newi = nextSelectArrMove(i + 1, nums, zeroNum);
                if (newi != -1) {
                    i = newi;
                    i--;
                }
            }
        }
        for (int j = 0; j < zeroNum; j++) {
            nums[nums.length - 1 - j] = 0;
        }


    }

    private int nextSelectArrMove(int i, int[] nums, int zeroNum) {
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
            nums[i - zeroNum] = nums[i];
        }
        return -1;
    }


    /**
     * 第一种, 数组中元素存在多次位移, 效率低
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                nextArrMove(i + 1, nums);
                nums[nums.length - 1] = 0;
                //指针不移动&数组范围缩小
                i--;
                length--;
            }
        }
    }

    private void nextArrMove(int i, int[] nums) {
        for (; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
    }
}
