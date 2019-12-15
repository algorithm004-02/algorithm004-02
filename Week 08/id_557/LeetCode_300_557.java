//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //动态规划
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        //动态规划 +二分查找 （不容易理解）
        int n = nums.length;
        if (n == 0) return 0;
        int[] tails = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = res;
            while (left < right) {
                int middle = (right + left) >> 1;
                if (tails[middle] < nums[i]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = nums[i];
            if (right == res) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
