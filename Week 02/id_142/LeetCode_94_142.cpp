/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.26%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    73.1K
 * Total Submissions: 106.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> sta;
        vector<int> rlt;

        TreeNode* cur = root;

        while (cur || !sta.empty()) {
            // 左子树一路冲下去
            while (cur) {
                sta.push(cur);
                cur = cur->left;
            }

            cur = sta.top();
            sta.pop();

            rlt.push_back(cur->val);
            cur = cur->right;
        }

        return rlt;
    }
};
// @lc code=end

