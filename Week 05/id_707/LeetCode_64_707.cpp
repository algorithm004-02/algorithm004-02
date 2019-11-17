#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <algorithm>
#include <iostream>
using namespace std;
// 最小路径和
int minPathSum(vector<vector<int>>& grid) {
	int n = grid.size();
	if (n == 0)
		return 0;
	int m = grid[0].size();
	if (m == 0)
		return 0;

	for (int i = 1; i <m; ++i)
	{
		grid[0][i] += grid[0][i - 1];
	}

	for (int i = 1; i<n; ++i)
	{
		grid[i][0] += grid[i - 1][0];
	}

	for (int i = 1; i<n; ++i)
	{
		for (int j = 1; j <m; ++j)
		{
			grid[i][j] += min(grid[i-1][j],grid[i][j-1]);
		}
	}

	return grid[n - 1][m - 1];
}

int main() {
	vector<vector<int>> grid = {
		{ 1,3,1 },
		{ 1,5,1 },
		{ 4,2,1 }
	};
	printf("最小路径和:%d\n", minPathSum(grid));
	system("pause");
	return 0;
}