/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.12%)
 * Likes:    429
 * Dislikes: 0
 * Total Accepted:    54.9K
 * Total Submissions: 75.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    vector<vector<int>> rlts;
public:
    vector<vector<int>> permute(vector<int>& nums) {
        dfs(0, nums);

        return rlts;
    }

    void dfs(int n, vector<int>& nums) {
        // 填满最后一格
        if (n == nums.size()) {
            rlts.push_back(nums);
            return;
        }

        for (int i = n; i < nums.size(); i++) {
            swap(nums[i], nums[n]);
            dfs(n+1, nums);
            swap(nums[i], nums[n]);
        }
    }
};
// @lc code=end

