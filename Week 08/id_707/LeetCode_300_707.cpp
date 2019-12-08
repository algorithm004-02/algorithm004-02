#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <algorithm>
#include <iostream>
using namespace std;
// 最长上升子序列
int lengthOfLIS(vector<int>& nums) {
	int Len = nums.size();
	vector<int> dp(Len, 1);
	int res = 0;
	for (int i = 0; i <nums.size(); ++i)
	{
		for (int j = 0; j <i; ++j)
		{
			if (nums[j] < nums[i])
			{
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		res = max(res, dp[i]);
	}
	return res;
}
int main() {
	vector<int> nums = { 10,9,2,5,3,7,101,18 };
	printf("最长上升子序列%d\n", lengthOfLIS(nums));
	system("pause");
	return 0;
}