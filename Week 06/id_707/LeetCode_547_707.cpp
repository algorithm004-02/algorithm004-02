#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;
// ≈Û”—»¶
int father[205];
int findFather(int x) {
	while (x != father[x] )
	{
		x = father[x];
	}
	return x;
}

void combine(int x, int y) {
	int faX = findFather(x);
	int faY = findFather(y);
	father[faX] = faY;
}

int findCircleNum(vector<vector<int>>& M) {
	int stu_nums = M[0].size();

	for (int i = 0; i<205; ++i)
	{
		father[i] = i;
	}
	for (int i = 0; i<stu_nums; ++i)
	{
		for (int j = i; j <stu_nums; ++j)
		{
			if (i!=j && M[i][j] == 1)
			{
				combine(i + 1, j + 1);
			}
		}
	}

	int cnt = 0;
	for (int i =1;i<=stu_nums; ++i)
	{
		if (father[i] == i)
		{
			cnt++;
		}
	}
	return cnt;
}
int main() {
	vector<vector<int>> nums = {
		{ 1,1,0 },
		{ 1,1,0 },
		{ 0,0,1 },
	};
	cout << findCircleNum(nums) << endl;
	system("pause");
	return 0;
}