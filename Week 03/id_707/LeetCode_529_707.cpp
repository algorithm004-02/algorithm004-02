#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
#include <algorithm>
using namespace std;
// É¨À×ÓÎÏ·
void update(vector<vector<char>>& board, int x, int y)
{
	if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size())
		return;
	if (board[x][y] != 'E'&&board[x][y] != 'M')
		return;
	if (board[x][y] == 'M')
	{
		board[x][y] = 'X';
		return;
	}
	int cnt = 0;
	for (int i = x - 1;i <= x + 1;i++)
		for (int j = y - 1;j <= y + 1;j++)
		{
			if (i == x&&j == y || i < 0 || i >= board.size() || j < 0 || j >= board[0].size())
				continue;
			if (board[i][j] == 'M' || board[i][j] == 'X')
				cnt++;
		}
	if (cnt > 0)
		board[x][y] = '0' + cnt;
	else
	{
		board[x][y] = 'B';
		for (int i = x - 1;i <= x + 1;i++)
			for (int j = y - 1;j <= y + 1;j++)
			{
				if (i == x&&j == y || i < 0 || i >= board.size() || j < 0 || j >= board[0].size())
					continue;
				update(board, i, j);
			}
	}

}

vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
	update(board, click[0], click[1]);
	return board;
}

int main() {
	vector<vector<char>> board = {
		{ 'E', 'E', 'E', 'E', 'E' },
	    { 'E', 'E', 'M', 'E', 'E' },
		{ 'E', 'E', 'E', 'E', 'E' },
		{ 'E', 'E', 'E', 'E', 'E' }
	};
	vector<int> click = { 3,0 };
	vector<vector<char>> outInfo = updateBoard(board, click);
	for (int i = 0; i <outInfo.size(); ++i)
	{
		vector<char> ArrC = outInfo.at(i);
		for (int j = 0; j < ArrC.size(); ++j)
		{
			printf("%c ",ArrC.at(j));
		}
		printf("\n");
	}
	system("pause");
	return 0;
}