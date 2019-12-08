/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (61.86%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    29.1K
 * Total Submissions: 46.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    int root_pre_idx;
    unordered_map<int, int> idx_map;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int idx = 0;
        for (auto& it : inorder) {
            idx_map.insert(make_pair(it, idx++));
        }
        root_pre_idx = 0;
        return build_tree(preorder, inorder, 0, inorder.size());
    }

    TreeNode* build_tree(vector<int>& preorder, vector<int>& inorder, int in_low, int in_high) {
        if (in_low == in_high) return nullptr;

        auto node = new TreeNode(preorder[root_pre_idx]);
        if (!node) return nullptr;

        auto root_idx_it = idx_map.find(preorder[root_pre_idx]);
        if (root_idx_it == idx_map.end()) return nullptr;
        
        root_pre_idx++;
        // 左子树
        node->left = build_tree(preorder, inorder, in_low, root_idx_it->second);
        // 右子树
        node->right = build_tree(preorder, inorder, root_idx_it->second + 1, in_high);

        return node;
    }
};
// @lc code=end

