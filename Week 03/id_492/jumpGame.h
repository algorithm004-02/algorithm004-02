#ifndef _JUMPGAME_H_
#define _JUMPGAME_H_

#include <iostream>
#include <vector>
#include <minwindef.h>

using namespace std;

class Solution {
public:
	bool canJump(vector<int>& nums) {
		int len = nums.size();
		int i = 0;
		for (int reach = 0; i < len && i <= reach; ++i) {
			reach = max(i + nums[i], reach);
		}
		return i == len;
	}
};


#endif // _JUMPGAME_H_
