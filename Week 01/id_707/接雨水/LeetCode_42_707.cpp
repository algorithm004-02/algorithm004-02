#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <stack>
#include <iostream>
#include <algorithm>
using namespace std;

// ÓêË®
int trap(vector<int>& nums) {
	int ans = 0;
	int current = 0;
	stack<int> st;
	while (current < nums.size()) {
		while (!st.empty() && nums[current] > nums[st.top()])
		{
			int top = st.top();
			st.pop();
			if (st.empty())
				break;
			int distance = current - st.top() - 1;
			int bounded = min(nums[current], nums[st.top()]) - nums[top];
			ans += distance * bounded;
		}
		st.push(current++);
	}
	return ans;
}


int main() {
	vector<int> nums = { 0,1,0,2,1,0,1,3,2,1,2,1 };
	cout << trap(nums) << endl;
	system("pause");
	return 0;
}
