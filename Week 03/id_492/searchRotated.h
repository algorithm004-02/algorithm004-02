#ifndef _SEARCHROTATED_H_
#define _SEARCHROTATED_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int search(vector<int>& nums, int target) {
		int low = 0, high = nums.size() - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		return low == high && nums[low] == target ? low : -1;
	}
};

#endif // 
