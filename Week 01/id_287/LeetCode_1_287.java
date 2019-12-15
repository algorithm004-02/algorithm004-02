package com.tulane.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @title https://leetcode-cn.com/problems/two-sum/
 */

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */

/**
 * 第一种 暴力求解
 * 第二种 存入hash表中, 并通过target-nums[i]取hash表, 找到下标
 */
public class LeetCode_1_287 {

    /**
     * 三刷: 一遍hash法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 第三种, 第二种的优化, 一遍hash, 并找寻是否有相符值
     * 交换了最终返回数组的顺序 因为根据遍历顺序, hash中的下标永远在当前i之前
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int[] arr = {map.get(key), i};
                return arr;
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     * 第二种, 先将每个下标的数值作为key存入hash表
     * 循环时用target-nums[i]取值, 找到对应值的下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int index = map.get(key);
                if(index == i){
                    continue;
                }
                int[] arr = {i, index};
                return arr;
            }
        }
        return null;
    }

    /**
     * 第一种 穷举
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int add = nums[i] + nums[j];
                if (target == add) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
