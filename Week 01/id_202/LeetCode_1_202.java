package com.algorithm.qinchao.homework.week01;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/17 21:06
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1_202 {
    /**
     * @param nums
     * @param target
     * @description 时间复杂度 = O(n^2)
     */
    public static int[] twoSumByViolence(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     *
     * @param nums
     * @param target
     * @return 时间复杂度= O(N)
     */
    public static int[] twoSumByCache(int[] nums, int target) {
        Map<Integer, Integer> cacheMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (cacheMap.containsKey(target - nums[i])) {
                return new int[]{cacheMap.get(target - nums[i]), i};
            } else {
                cacheMap.put(nums[i], i);
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        System.out.println(ToStringBuilder.reflectionToString(LeetCode_1_202.twoSumByViolence(nums, target)));
        System.out.println(ToStringBuilder.reflectionToString(LeetCode_1_202.twoSumByCache(nums, target)));
    }
}
