package src.main.java.com.fans.algorithm00402.week8.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长子序列
 */
public class LeetCode_300_232 {

    /*
    * 1. DFS + 回溯 + 剪枝
    *
    * */
//    private int max = 0;
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length <= 1) return nums.length;
//        return dfs(0, nums, 0, -1);
//    }
//
//    private int dfs(int begin, int[] nums, int count, int prev) {
//
//        for (int i = begin; i < nums.length && nums.length - i > max - count; i ++) {
//            if (count > 0 && nums[i] <= prev) continue;
//            count ++;
//            max = Math.max(dfs(i + 1, nums, count, nums[i]), max);
//            count --;
//        }
//
//        return Math.max(count, max);
//    }

    /*
    * 2. 动态规划
    * */
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//        int res = 0;
//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = 0; j < i; j ++) {
//                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
//            }
//            res = Math.max(res, dp[i]);
//        }
//
//        return res;
//    }

    /*
    * 3. 二分法
    * */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i ++) {
            int left = 0;
            int right = end + 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (tail[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

                tail[left] = nums[i];
                if (left == end + 1) end ++;
            }
        }

        return end + 1;
    }



    public static void main(String[] args) {
        LeetCode_300_232 code = new LeetCode_300_232();
        int[] a = {1,3,6,7,9,4,10,5,6};
        System.out.println(code.lengthOfLIS(a));
    }
}
