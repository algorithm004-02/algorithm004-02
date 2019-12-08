package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【组合】
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LeetCode_77_232 {

    /**
     * 1. 回溯法
     *  - 开始的时候遍历每一种情况
     *  - 后面根据规则，进行剪枝
     *  - 还有一个关键优化点(剪枝)，在于有无用遍历的节点。n - (max - temp.size()) + 1 有效的避免掉了无用节点
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1 ,k , n, new ArrayList<>(), res);
        return res;
    }

    private void helper(int fisrt, int max, int n, List<Integer> temp, List<List<Integer>> res) {
        // terminator
        if (temp.size() == max) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // process & drill down
        for (int i = fisrt; i <= n - (max - temp.size()) + 1; i ++) {
            temp.add(i);
            helper(i + 1,max, n, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_77_232 code = new LeetCode_77_232();
        System.out.println(code.combine(3, 3));
    }
}
