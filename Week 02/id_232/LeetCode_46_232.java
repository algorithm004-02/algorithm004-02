package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 【全排列】
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class LeetCode_46_232 {

    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 1. 回溯法
     *  - 先写出穷举
     *  - 避免重复使用一个数
     */
//    public List<List<Integer>> permute(int[] nums) {
//        helper(0, new ArrayList<>(), nums);
//        return ans;
//    }
//
//    private void helper(int level, List<Integer> res, int[] nums) {
//        // terminator
//        if (level == nums.length) {
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//        for (int i = 0; i < nums.length; i ++) {
//            int size = res.size();
//            Boolean isRepeat = false;
//            if (size != 0) {
//                while (size -- > 0) {
//                    if (res.get(size) == nums[i]) {
//                        isRepeat = true;
//                        break;
//                    }
//                }
//            }
//            if (!isRepeat) {
//                res.add(nums[i]);
//                helper(level + 1, res, nums);
//                res.remove(res.size() - 1);
//            }
//        }
//    }

    /**
     * 2. 回溯法改进  （然而效果差不多。。。。）
     *  - 对比上面主要在剪枝的时候有所改进
     *  - 不去每次都遍历，而是把用过的保存下来 (空间换时间)
     */
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(0, new ArrayList<>(), nums);
        return ans;
    }

    private void helper(int level, List<Integer> res, int[] nums) {
        // terminator
        if (level == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(i) != null) continue;
            res.add(nums[i]);
            cache.put(i,1);
            helper(level + 1, res, nums);
            res.remove(res.size() - 1);
            cache.remove(i);
        }
    }

    public static void main(String[] args) {
        LeetCode_46_232 code = new LeetCode_46_232();
        System.out.println(code.permute(new int[]{1,2,3}));
    }
}
