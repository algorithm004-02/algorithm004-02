#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <algorithm>
#include <iostream>
using namespace std;
// 最长有效括号
int longestValidParentheses(string s) {
	int maxans = 0;
	vector<int> dp(s.size(),0);
	for (int i = 1; i <s.size(); ++i)
	{
		if (s[i] == ')')
		{
			if (s[i-1] == '('){
				dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
			}
			else if(i - dp[i-1] >0 && s[i-dp[i-1]-1] == '('){
				dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
			}
			maxans = max(maxans, dp[i]);
		}
	}
	return maxans;
}
int main() {
	string s = "(()";
	printf("最长有效括号%d\n", longestValidParentheses(s));
	system("pause");
	return 0;
}