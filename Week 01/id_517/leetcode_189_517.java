/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (38.98%)
 * Likes:    386
 * Dislikes: 0
 * Total Accepted:    72.5K
 * Total Submissions: 185.9K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // planA(nums,k);
        // planB(nums,k);
        planC(nums,k);
    }

    // 暴力求解 依次交换元素
    public void planA(int[] nums, int k) {
        int temp, tail;
        //循环k次，每次遍历nums将尾指针移到首位
        for (int i = 0; i < k; i++) {
            tail = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = tail;
                tail = temp;
            }
        }
    }

    //根据K拆分两个数组，位置交换
    public void planB(int[] nums, int k) {
        int[] newNums=new int[nums.length];
        //新数组前半部分是nums的后半部分
        for(int x=0;x<k;x++){
            newNums[x]=nums[nums.length-k+x];
        }
        //新数组后半部分是nums的前半部分
        for(int y=0;y<nums.length-k;y++){
            newNums[y+k]=nums[y];
        }
        for(int z=0;z<nums.length;z++){
           nums[z]=newNums[z];
        }
        
    }   

    //反转法
    public void planC(int[] nums, int k) {
        //如果不对k进行取余运算，当k>nums.length时会出现数组下标越界，测试用例 [-1],2
        k = k % nums.length;
        //交换所有的数组
        reverse(nums, 0, nums.length - 1);
        //前半部分交换
        reverse(nums, 0, k - 1);
        //后半部分交换
        reverse(nums, k, nums.length - 1);
    }

    // 循环对nums从start到end进行反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

