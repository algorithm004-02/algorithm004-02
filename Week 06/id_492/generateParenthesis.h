#ifndef _GENERATEPARENTHESIS_H_
#define _GENERATEPARENTHESIS_H_

#include <iostream>
#include <vector>
#include <string>

using namespace std;

// ¶¯Ì¬¹æ»®
class Solution {
public:
	vector<string> generateParenthesis(int n) {
		vector<vector<string>> dp(n + 1, vector<string>());
		dp[0].push_back("");
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				for (auto& s1 : dp[j]) {
					for (auto& s2 : dp[i - 1 - j]) {
						dp[i].push_back("(" + s1 + ")" + s2);
					}
				}
			}
		}
		return dp[n];
	}
};


// µÝ¹é
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        string s;
        generate(0, 0, n, s);
        return m_ans;
    }

private:
    void generate(int left, int right, int n, string& s) {
        if (left == n && right == n) {
            m_ans.push_back(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

private:
    vector<string> m_ans;
};

#endif
