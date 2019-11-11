/*
 * @lc app=leetcode.cn id=42 lang=cpp
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (46.52%)
 * Likes:    652
 * Dislikes: 0
 * Total Accepted:    35.7K
 * Total Submissions: 76.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
public:
    int trap(vector<int>& height) {
        int sum = 0;
        stack<int> st;

        int current = 0;
        // 遍历每个高度
        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                auto top = st.top();
                st.pop();
                if (st.empty()) break;

                auto distance = current - st.top() - 1;
                auto dif_height = min(height[current] - height[top], height[st.top()] - height[top]);
                sum += (distance * dif_height);            
            }
            st.push(current++);
        }

        return sum;
    }
};
// @lc code=end

