/*
* @Author: yangyazhen
* @Date:   2019-10-28 00:38:57
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-28 00:39:02
*/
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        if (root == nullptr) {
            return ret;
        }
        TreeNode * cur;
        stack<TreeNode *> s;
        s.push(root);
        while (!s.empty()) {
            cur = s.top();
            s.pop();
            ret.push_back(cur->val);
            if (cur->right != nullptr) {
                s.push(cur->right);
            }
            if (cur->left != nullptr) {
                s.push(cur->left);
            }
        }
        return ret;
    }
};
// 1. 递归处理
// class Solution {
// public:
//     vector<int> preorderTraversal(TreeNode* root) {
//         vector<int> ret;
//         recursive(root, ret);
//         return ret;
//     }
    
//     void recursive(TreeNode * root, vector<int> &ret) {
//         if (root == nullptr) {
//             return;
//         }
//         ret.push_back(root->val);
//         recursive(root->left, ret);
//         recursive(root->right, ret);
//     }
// };