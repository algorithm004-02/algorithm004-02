#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;

int removeDuplicates(vector<int>& nums) {
	if (nums.size() == 0)
		return 0;
	int index = 0; 
	for (int i = 0; i < nums.size(); ++i) {
		if (nums[i] != nums[index]) {
			index++;
			nums[index] = nums[i];
		}
	}
	return index +1;
}

void showArr(vector<int> arr, int len) {
	for (int i = 0; i < len; ++i) {
		cout << " " << arr[i];
	}
	cout << endl;
}

int main() {
	vector<int> nums = { 0,0,1,1,1,2,2,3,3,4 };
	int len = removeDuplicates(nums);
	showArr(nums, len);
	system("pause");
	return 0;
}