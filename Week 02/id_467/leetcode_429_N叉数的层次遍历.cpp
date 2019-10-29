class Solution {
public:
   vector<vector<int>> levelOrder(Node* root) {
        if (!root) return {};
        vector<vector<int>> res;
        queue<Node*> q;
        q.push(root);
        while (!q.empty()) {
            vector<int> v;
            for (int i = q.size(); i; i--) {
                Node* cur = q.front();
                q.pop();
                v.push_back(cur->val);
                for (Node* it : cur->children) {
                    q.push(it);
                }
            }
            res.push_back(v);
        }
        return res;
    }
};