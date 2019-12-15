/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (54.48%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    27K
 * Total Submissions: 48.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
private:
    vector<vector<int>> rlts;
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
       sort(nums.begin(), nums.end());

        vector<int> rlt;
        vector<bool> visited(nums.size(), false);
        dfs(0, nums, rlt, visited);

        return rlts;
    }

    void dfs(int n, vector<int>& nums, vector<int>& rlt, vector<bool>& visited) {
        if (rlt.size() == nums.size()) {
            rlts.push_back(rlt);
            return;
        }

        for (int i = 0; i < nums.size(); ++i) {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) continue;

            rlt.push_back(nums[i]);
            visited[i] = true;
            dfs(n+1, nums, rlt, visited);
            visited[i] = false;
            rlt.pop_back();
        }
    }
};
// @lc code=end

