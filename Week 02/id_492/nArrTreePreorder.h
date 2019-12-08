#ifndef _NARRTREEPREORDER_H_
#define _NARRTREEPREORDER_H_

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

// µÝ¹é
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> ans;
        pOrder(root, ans);
        return ans;
    }

    void pOrder(Node* root, vector<int>& ans) {
        if (root == NULL) {
            return;
        }

        ans.push_back(root->val);
        for (int i = 0; i < root->children.size(); ++i) {
            pOrder(root->children[i], ans);
        }
    }
};

// µü´ú
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> ans;
        stack<Node*> nodeStack;
        if (root == NULL) {
            return ans;
        }
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            Node* node = nodeStack.top();
            nodeStack.pop();
            ans.push_back(node->val);
            for (int i = node->children.size() - 1; i >= 0; --i) {
                nodeStack.push(node->children[i]);
            }
        }

        return ans;
    }
};

#endif
