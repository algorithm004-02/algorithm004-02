/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (62.96%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    11.3K
 * Total Submissions: 17.8K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/*
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
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (root == nullptr) return {};

        map<int, vector<int>> m;        

        queue<pair<Node*, int>> q;
        q.push(make_pair(root, 0));
        while (!q.empty()) {
            m[q.front().second].push_back(q.front().first->val);
            for (auto& child : q.front().first->children) {
                if (child == nullptr) continue;
                q.push(make_pair(child, q.front().second + 1));
            }
            q.pop();
        }

        vector<vector<int>> rlts;
        for (auto& it : m) {
            rlts.push_back(it.second);
        }

        return rlts;
    }
};
// @lc code=end

