#ifndef _SEARCHMATRIX_H_
#define _SEARCHMATRIX_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		int row = matrix.size();
		if (row == 0) {
			return false;
		}
		int col = matrix[0].size();

		int left = 0, right = row * col - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / col][pivotIdx % col];
			if (target == pivotElement) {
				return true;
			}
			else {
				if (target < pivotElement) {
					right = pivotIdx - 1;
				}
				else {
					left = pivotIdx + 1;
				}
			}
		}
		return false;
	}
};

#endif
