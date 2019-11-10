//递归
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        dfs(res, root);
        return res;
    }
    void dfs(vector<int>& _res, TreeNode* r) {
        if (NULL == r) return;
        dfs(_res, r->left);
        _res.push_back(r->val);
        dfs(_res, r->right);
    }
};

//迭代
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode> s;
        vector<int> res;
        TreeNode* t = root;
        while(t || !s.empty()) {
            while (t) {
                s.push(*t);
                t = t->left;
            }
            if (!s.empty()) {
                res.push_back(s.top().val);
                t = s.top().right;
                s.pop();
            }
        }
        return res;
    }
};
