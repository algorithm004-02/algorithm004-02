#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
#include <algorithm>
using namespace std;
// 跳跃游戏
bool canJump(vector<int>& nums) {
	int k = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		if (i > k) 
			return false;
		k = max(k, i + nums[i]);
	}
	return true;
}

int main() {
	vector<int> nums = { 3,2,1,0,4 };
	if (canJump(nums)) {
		printf("能跳跃\n");
	}
	else {
		printf("不能跳跃\n");
	}

	system("pause");
	return 0;
}