package Week08.Chapter19;

public class LeetCode_8_300 {
    public int lengthOfLIS(int[] nums) {
        // 状态转移方程:dp[i] = max{1 + dp[j] for j < i if nums[j] < nums[i]}
        if (nums.length == 0) {
            return 0;
        }
        final int[] s = new int[nums.length];
        int maxLen = 1;
        for (int i = 0; i < s.length; i++) {
            s[i] = 1;
        }
        for (int index = 1; index < nums.length; index++) {
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    s[index] = Math.max(s[j] + 1, s[index]);
                    if (s[index] > maxLen) {
                        maxLen = s[index];
                    }
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] ints = {1, 2, 2};
        final LeetCode_8_300 test = new LeetCode_8_300();
        System.out.println(test.lengthOfLIS(ints));

    }
}