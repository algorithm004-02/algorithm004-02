#ifndef _LENGTHOFLIS_H_
#define _LENGTHOFLIS_H_

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int lengthOfLIS(vector<int>& nums) {
		int len = nums.size();
		if (len < 2) {
			return len;
		}

		vector<int> dp(len, 1);
		int res = dp[0];
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
					res = max(res, dp[i]);
				}
			}
		}
		return res;
	}
};

#endif // _LENGTHOFLIS_H_
