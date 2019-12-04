/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.04%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    11.4K
 * Total Submissions: 16.1K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
    vector<int> postorder(Node* root) {
        if (root == nullptr) return {};

        vector<int> rlt;

        stack<Node*> st;
        st.push(root);
        st.push(root);
        while (!st.empty()) {
            auto cur = st.top();
            st.pop();

            if (!st.empty() && cur == st.top()) {
                for (auto it = cur->children.rbegin(); it != cur->children.rend(); ++it) {
                    st.push(*it);
                    st.push(*it);
                }
            } else {
                rlt.push_back(cur->val);
            }
        }

        return rlt;
    }
};
// @lc code=end

