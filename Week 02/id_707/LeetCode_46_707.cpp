#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

void swap(int &a, int &b) {
	int temp = a;
	a = b;
	b = temp;
}

void backtrack(vector<int>& nums, vector<vector<int>> &res, int i) {
	if (i == nums.size())
	{
		res.push_back(nums);
		return;
	}
	int a = i;
	for (int j = i; j <nums.size(); ++j)
	{
		if (i != j)
		 swap(nums[i], nums[j]);
		backtrack(nums, res, i+1);
		if (i != j)
		 swap(nums[i], nums[j]);
	}
}

// È«ÅÅÁÐ
vector<vector<int>> permute(vector<int>& nums) {
	vector<vector<int>> res;
	backtrack(nums, res, 0);
	return res;
}

int main() {
	vector<int> nums = { 1,2,3 };
	permute(nums);


	system("pause");
	return 0;
}