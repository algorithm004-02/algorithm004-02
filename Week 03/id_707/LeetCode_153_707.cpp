#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;
// 寻找旋转排序数组最小值
int findMin(vector<int>& nums) {
	if (nums.size() == 1)
		return nums[0];
	int left = 0;
	int right = nums.size() - 1;
	if (nums[0] < nums[right])
	{
		return nums[0];
	}

	while (right >= left) {
		int mid = left + (right - left) / 2;
		
		if (nums[mid] > nums[mid + 1]){
			return nums[mid + 1];
		}
		if (nums[mid-1] > nums[mid] ){
			return nums[mid];
		}

		if (nums[mid] > nums[0]){
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	return -1;
}

int main() {
	vector<int> nums = { 4,5,6,7,0,1,2 };
	printf("min=%d\n", findMin(nums));
	system("pause");
	return 0;
}