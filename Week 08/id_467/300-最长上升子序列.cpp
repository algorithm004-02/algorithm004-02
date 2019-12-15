方法一DP：
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int res = 1;
        vector<int> dp(nums.size()+1, 1);
        for (int i = 1; i < nums.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};

//方法二
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        vector<int> res;
        for (int i = 0; i < nums.size(); ++i) {
            auto it = std::lower_bound(res.begin(), res.end(), nums[i]);
            if (res.end() == it)
                res.push_back(nums[i]);
            else 
                *it = nums[i];
        }
        return res.size();
    }
};