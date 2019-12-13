package com.algorithm.qinchao.homework.week08;

import java.util.Arrays;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/12/13 16:32
 * @description 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_300_202 {
    /**
     * 重复子问题：f(i) = f(i-1)+1
     * 状态数组：dp
     * 状态方程：f(i) = f(i-1)+1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        Arrays.fill(dp, 1);
        //从第二个开始比较
        for (int i = 1; i < nums.length; i++) {
            //后面从0开始跟前面的比较
            for (int j = 0; j < i; j++) {
                //如果后面的比前面的大，证明是顺序了
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //取出最大值
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            //dp指针
            int i = 0;
            //标识是否有替换指针
            int j = res;
            while(i < j) {
                int m = (i + j) >>1;
                //如果当前的大于前面的，升序，需要后移
                if(dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = num;
            if(res == j) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode_300_202().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LeetCode_300_202().lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
