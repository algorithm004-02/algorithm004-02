package src.main.java.com.fans.algorithm00402.week2.homework;


import java.util.HashMap;

/*
【两数之和】
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*
* */
public class LeetCode_1_232 {

    /** 1. 暴力法 O(n^2)   O(1) */
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0 ; i < nums.length - 1 ; i ++) {
//            for (int j = i + 1; j < nums.length ; j ++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i , j};
//                }
//            }
//        }
//        return new int[0];
//    }

    /** 2. 两遍Hash O(n)  O(n)
    *  - 第一遍遍历的时候， 把所有nums[i]的值存在Hash中
    *  - 第二遍的时候，直接查看hash中是否存在target - num[i] */
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i ++) hashMap.put(nums[i], i);
//        for (int i = 0; i < nums.length; i ++) {
//            int complement = target - nums[i];
//            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
//                return new int[]{i ,hashMap.get(complement)};
//            }
//        }
//        return new int[0];
//    }

    /** 3. 一遍Hash O(n) O(n) */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(target - nums[i], i);
            } else {
                return new int[]{hashMap.get(nums[i]), i};
            }
        }
        return new int[0];
    }
}
