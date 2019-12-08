#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;
// 二叉树中序遍历
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
};
vector<int> ans;
vector<int> inorderTraversal(TreeNode* root) {
	if (root)
	{
		inorderTraversal(root->left);
		ans.push_back(root->val);
		inorderTraversal(root->right);
	}
	return ans;
}
// 二叉树初始化
void creatTree(TreeNode * &tree) {
	int num;
	cout << "输入数字" << endl;
	cin >> num;
	if (num == 0)
	{
		tree = nullptr;
	}
	else {
		tree = new TreeNode();
		tree->val = num;
		creatTree(tree->left);
		creatTree(tree->right);
	}

}
int main() {
	TreeNode *tree = nullptr;
	creatTree(tree);
	inorderTraversal(tree);
	system("pause");
	return 0;
}