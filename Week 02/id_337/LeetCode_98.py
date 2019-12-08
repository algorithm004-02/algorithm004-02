2.给定一个 N 叉树，返回其节点值的后序遍历。
 class Solution {
public:
    vector<int> ans;
    vector<int> postorder(Node* root) {
        if(root){
            for(int i = 0; i < root->children.size(); ++i)
                postorder(root->children[i]);
            ans.push_back(root->val);
        }
        return ans;
    }
}
