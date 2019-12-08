#ifndef _DISTINCTSUBSEQUENCES_H_
#define _DISTINCTSUBSEQUENCES_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int numDistinct(string s, string t) {
		int m = t.size();
		int n = s.size();
		if (m > n) {
			return 0;
		}
		vector<vector<long long int>> dp(m + 1, vector<long long int>(n + 1, 0));

		for (int k = 0; k <= n; k++) {
			dp[0][k] = 1;
		}

		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= m; i++) {
				if (t[i - 1] == s[j - 1]) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				}
				else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}
};

#endif // _DISTINCTSUBSEQUENCES_H_
