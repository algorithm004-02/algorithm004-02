#ifndef _NQUUENSII_H_
#define _NQUUENSII_H_

#include <iostream>

using namespace std;

class Solution {
public:
	int totalNQueens(int n) {
		count = 0;
		size = (1 << n) - 1;
		solveNQuuens(0, 0, 0);
		return count;
	}

private:
	void solveNQuuens(int row, int ld, int rd) {
		if (row == size) {
			count++;
			return;
		}

		int pos = size & (~(row | ld | rd));
		while (pos != 0) {
			int p = pos & (-pos);
			pos -= p;
			solveNQuuens(row | p, (ld | p) << 1, (rd | p) >> 1);
		}
	}

private:
	int count;
	int size;
};

#endif
