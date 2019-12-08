class Solution {
public int lengthOfLIS(int[] nums) {
	if (nums.length == 0) {
		return 0;
	}
	/**
        dp[i]: 所有长度为i的递增子序列中, 最小的那个序列尾数。dp数组的长度len其实就是最长上升子序列的长度。由定义知dp数组必然是一个递增数组。
        对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
        1. num > dp[len], 表示num比所有已知递增序列的尾数都大, 将num添加入dp数组尾部, dp数组的长度+1，即len+1。
        2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]。相当于在升序的dp数组中查找大于等于num的第一个数dp[i]，即dp[i]>=num，把dp[i]替换成num。
        **/

	int[] dp = new int[nums.length + 1];
	int len = 1;
	dp[1] = nums[0];
	for (int i = 1; i < nums.length; ++i) {
	   if (nums[i] > dp[len]) {
		dp[++len] = nums[i];
	} else if (nums[i] < dp[len]) {
            // 在升序的dp数组中查找大于等于nums[i]的第一个数，然后替换成nums[i]
	int left = 1, right = len;
	while (left <= right) {
		int mid = (left + right) >>> 1;
		if (dp[mid] < nums[i]) {
		    left = mid + 1;
		} else { // dp[mid] >= nums[i]的情况
		      if (mid - 1 >= left && dp[mid - 1] >= nums[i]) {
		right = mid - 1; // dp[mid-1]也是大于等于nums[i]，所以可以减小right赋值为mid-1。不然如果让right = mid;  在left==right 的时候，那么就有mid==left，则right = mid;，
				就会让right值没有变化，就陷入死循环。
				} else {
					dp[mid] = nums[i];
					// dp[mid-1]不是大于等于nums[i]，那么dp[mid]就是有序数组中第一个大于等于nums[i]的数，于是把dp[mid]替换成nums[i]，退出循环
					break;
					}
				}
			}
		}
	}
	return len;
}
}


// Dynamic programming.
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}