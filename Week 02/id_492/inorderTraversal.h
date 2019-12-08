#ifndef _INORDERTRAVERSAL_H_
#define _INORDERTRAVERSAL_H_

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// µÝ¹é·¨
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorder(root, result);
        return result;
    }

private:
    void inorder(TreeNode* root, vector<int>& reslut) {
        if (root == NULL) {
            return;
        }
        inorder(root->left, reslut);
        reslut.push_back(root->val);
        inorder(root->right, reslut);
    }
};

// µü´ú·¨
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> todo;

        while (root || !todo.empty()) {
            while (root) {
                todo.push(root);
                root = root->left;
            }
            root = todo.top();
            todo.pop();
            result.push_back(root->val);
            root = root->right;
        }

        return result;
    }
};


#endif
