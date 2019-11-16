#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;
// Ğı×ªÅÅĞòÊı×é
int search(vector<int>& nums, int target) {
	int lo = 0; 
	int hi = nums.size() - 1;

	while (lo < hi)
	{
		int mid = (lo + hi) / 2;
		if (nums[0] <= nums[mid] && ( target > nums[mid] || target < nums[0]))
		{
			lo = mid + 1;
		}
		else if (target > nums[mid] && target < nums[0])
		{
			lo = mid + 1;
		}
		else {
			hi = mid;
		}
	}
	return lo == hi && nums[lo] == target ? lo : -1;
}

int main() {
	vector<int> nums = { 4,5,6,7,0,1,2 };
	printf("index=%d\n", search(nums, 3));
	system("pause");
	return 0;
}