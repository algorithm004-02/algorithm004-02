#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;
// 二叉树前序遍历
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
};
vector<int> num;
vector<int> preorderTraversal(TreeNode* root) {
	if (root)
	{
		num.push_back(root->val);
		preorderTraversal(root->left);
		preorderTraversal(root->right);
	}
	return num;
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
	num = preorderTraversal(tree);
	for (int i = 0; i < num.size(); ++i)
	{
		cout << num.at(i) << " ";
	}
	system("pause");
	return 0;
}