class Solution {
public:
    vector<int> ket;
    vector<int> preorderTraversal(TreeNode* root) {
        pre_travel(root);
        return ket;
    }
    void pre_travel(TreeNode* root)
    {
        if(root)//当前结点非空
        {
            ket.push_back(root->val);//访问根节点
            pre_travel(root->left);//递归左子树
            pre_travel(root->right);//递归右子树
        }
    }
};