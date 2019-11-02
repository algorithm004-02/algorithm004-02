package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 【全排列 II】
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class LeetCode_47_232 {

    /**
     * 1. 回溯
     *  - 在 46 题的基础上引入hash去重
     */
//    HashMap<String, Integer> hashMap = new HashMap<>();
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        helper(0, new ArrayList<>() ,nums, res, new int[nums.length]);
//        return res;
//    }
//
//    private void helper(int first, ArrayList<Integer> tempRes, int[] nums, List<List<Integer>> res, int[] cache) {
//        // terminator
//        if (tempRes.size() == nums.length) {
//            if (!hashMap.containsKey(tempRes.toString())) res.add(new ArrayList<>(tempRes));
//            hashMap.put(tempRes.toString(), 1);
//            return;
//        }
//
//        // process current logic
//        for (int i = 0; i < nums.length; i ++) {
//            if (cache[i] == 1) continue;
//            tempRes.add(nums[i]);
//            cache[i] = 1;
//            // drill down
//            helper(first + 1, tempRes, nums, res, cache);
//            // restore state
//            tempRes.remove(tempRes.size() - 1);
//            cache[i] = 0;
//        }
//    }


    /**
     * 2. 回溯
     *  - 在遍历的过程中去重复
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(new ArrayList<>() ,nums, res, new int[nums.length]);
        return res;
    }

    private void helper(ArrayList<Integer> tempRes, int[] nums, List<List<Integer>> res, int[] cache) {
        // terminator
        if (tempRes.size() == nums.length) {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        // process current logic
        for (int i = 0; i < nums.length; i ++) {
            if (cache[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && cache[i - 1] == 0)) continue;
            tempRes.add(nums[i]);
            cache[i] = 1;
            // drill down
            helper(tempRes, nums, res, cache);
            // restore state
            tempRes.remove(tempRes.size() - 1);
            cache[i] = 0;
        }
    }

    public static void main(String[] args) {
        LeetCode_47_232 code = new LeetCode_47_232();
        System.out.println(code.permuteUnique(new int[]{1,1,2}));
    }
}
