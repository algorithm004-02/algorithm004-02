#ifndef _LONGESTPALINDROME_H_
#define _LONGESTPALINDROME_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	string longestPalindrome(string s) {
		int len = s.size();
		if (len <= 1) {
			return s;
		}
		string res = s.substr(0, 1);

		int resnum = 1;
		vector<vector<bool>> dp(len, vector<bool>(len, false));

		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (s[i] == s[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i + 1 > resnum) {
						resnum = j - i + 1;
						res = s.substr(i, resnum);
					}
				}
			}
		}
		return res;
	}
};

#endif // _LONGESTPALINDROME_H_
