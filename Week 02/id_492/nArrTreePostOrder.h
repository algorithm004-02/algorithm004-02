#ifndef _NARRTREEPOSTORDER_H_
#define _NARRTREEPOSTORDER_H_

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

// 从上往下遍历，再反转
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> result;
        stack<Node*> nodeStack;
        if (root == NULL) {
            return result;
        }
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            Node* node = nodeStack.top();
            nodeStack.pop();
            for (int i = 0; i < node->children.size(); ++i) {
                auto chilNode = node->children[i];
                nodeStack.push(node->children[i]);
            }
            result.push_back(node->val);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};

// 递归
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> result;
        pOrder(root, result);
        return result;
    }

    void pOrder(Node* root, vector<int>& result) {
        if (root == NULL) {
            return;
        }
        for (int i = 0; i < root->children.size(); ++i) {
            pOrder(root->children[i], result);
        }
        result.push_back(root->val);
    }
};

#endif
