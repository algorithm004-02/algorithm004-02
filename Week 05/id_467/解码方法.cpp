class Solution {
public:
    int numDecodings(string s) {
        int n = s.length();
        int dp[n+1] = {0};
        dp[n] = 1;
        if (s[n-1] != '0') {
            dp[n-1] = 1;
        }

        for (int i = n - 2; i >= 0; --i) {
            if (s[i] == '0') continue;
            int sum = (s[i] - '0') * 10 + (s[i+1] - '0');
            dp[i] = sum > 26 ? dp[i+1] : dp[i+1] + dp[i+2];
        }
        return dp[0];
    }
};