/*
* @Author: yangyazhen
* @Date:   2019-10-28 00:25:08
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-28 00:25:11
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ret;
        stack<TreeNode*> s;
        TreeNode * cur = root;
        while (!s.empty() || cur != nullptr) {
            while (cur != nullptr) {
                s.push(cur);
                cur = cur->left;
            }
            cur = s.top();
            s.pop();
            ret.push_back(cur->val);
            cur = cur->right;
        }
        return ret;
    }
};
// 1. 递归求解
// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//         vector<int> ret;
//         recursive(root, ret);
//         return ret;
//     }
    
//     void recursive(TreeNode * root, vector<int> & ret) {
//         if (root == nullptr) {
//             return;
//         }
//         recursive(root->left, ret);
//         ret.push_back(root->val);
//         recursive(root->right, ret);
//     }
// };