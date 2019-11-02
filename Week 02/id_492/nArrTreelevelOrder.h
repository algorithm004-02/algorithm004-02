#ifndef _NARRTREELEVELORDER_H_
#define _NARRTREELEVELORDER_H_

#include <iostream>
#include <vector>
#include <queue>

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

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> ans;
        queue<Node*> qNode;
        if (root == NULL) {
            return ans;
        }

        qNode.push(root);
        while (!qNode.empty()) {
            vector<int> midans;
            int qsize = qNode.size();
            for (int i = 0; i < qsize; ++i) {
                Node* curnode = qNode.front();
                qNode.pop();
                midans.push_back(curnode->val);
                for (auto node : curnode->children) {
                    qNode.push(node);
                }
            }
            ans.push_back(midans);
        }
        return ans;
    }
};

#endif
