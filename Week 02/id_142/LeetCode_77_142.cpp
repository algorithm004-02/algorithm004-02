/*
 * @lc app=leetcode.cn id=77 lang=cpp
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (70.71%)
 * Likes:    176
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 33.2K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
private:
    int MAX_n;
    int MAX_k;
public:
    vector<vector<int>> combine(int n, int k) {
        if (k < 1 || n < 1 || k > n) return {};

        MAX_k = k;
        MAX_n = n;
        vector<vector<int>> rlts;
        vector<int> rlt;
        dfs(1, rlt, rlts);

        return rlts;
    }

    void dfs(int n, vector<int>& rlt, vector<vector<int>>& rlts) {
        if (rlt.size() == MAX_k) {
            rlts.push_back(rlt);
            return;
        }

        // 插入n
        for (int i = n; i <= MAX_n - (MAX_k - rlt.size()) + 1; ++i) {
            rlt.push_back(i);
            dfs(i+1, rlt, rlts);
            rlt.pop_back();
        }
    }
};
// @lc code=end

