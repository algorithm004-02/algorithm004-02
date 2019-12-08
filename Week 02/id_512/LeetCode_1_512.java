package WEEK1.LeetCode.ArrayQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * * */


public class TwoSum {

    /**
      方法1：穷举 暴力求解
      思路：先遍历一遍，然后看看是否存在有target -[i] 的元素。然后得出.
      tips 如果有两个解，则返回两个新的int[]。
     */

    //先把所有存在一个HashMap里。然后俩容器再匹配。
    public int[] twoSum_Exhaustion_One(int[] nums, int target) {
        Map<Integer,Integer> temp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i],i);
        }
        for (int i = 0; i < nums.length ; i++) {
            int minis = target - nums[i];
            //contains里面是否有循环，时间复杂度是否会是O(n^2)
            if (temp.containsKey(minis) && temp.get(minis) != i) {
                return new int[]{i,temp.get(minis)};
            }
        }
        throw new NullPointerException();
    }
    //先把差存在一个HashMap里。然后俩容器再匹配。
    public int[] twoSum_Exhaustion_Two(int[] nums,int target) {
        Map<Integer,Integer> temp = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int minis = target - nums[i];
            temp.put(minis,i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(nums[i]) && temp.get(nums[i]) != i) {
                return new int[]{i,temp.get(nums[i])};
            }
        }
        throw new NullPointerException();
    }
    //只用一个for，Map，最开始插入，然后插入时便利找是否存在目标。
    public int[] twoSum_Exhaustion_Three(int[] nums,int target) {
        Map<Integer,Integer> temp = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int minis = target - nums[i];
            if (temp.containsKey(minis)) {
                return new int[] {temp.get(minis),i};
            }
            temp.put(nums[i],i);
        }
        throw new NullPointerException();
    }

    //先循环第一遍，再第二遍 头指针+1的内循环的时候，把对应的值拿到
    public int[] twoSum_(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target -nums[i])
                    return new int[]{i,j};
            }
        }
        throw new NullPointerException();
    }



}
