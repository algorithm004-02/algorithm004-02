#ifndef _NUMDISTINCT_H_
#define _NUMDISTINCT_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int numDistinct(string s, string t) {
		int len = t.size();
		vector<long> dp(len + 1, 0);
		dp[0] = 1;

		vector<int> hash(128, -1);
		vector<int> next(len, -1);
		for (int i = 0; i < len; i++) {
			int c = t[i];
			next[i] = hash[c];
			hash[c] = i;
		}

		for (int i = 0; i < s.size(); i++) {
			for (int j = hash[s[i]]; j >= 0; j = next[j]) {
				dp[j + 1] += dp[j];
			}
		}

		return dp[len];
	}
};

#endif // _NUMDISTINCT_H_
