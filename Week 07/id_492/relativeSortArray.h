#ifndef _RELATIVESORTARRAY_H_
#define _RELATIVESORTARRAY_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
		vector<int> count(1001, 0);
		for (auto n1 : arr1) {
			count[n1]++;
		}
		int i = 0;
		for (auto n2 : arr2) {
			while (count[n2]-- > 0) {
				arr1[i++] = n2;
			}
		}

		for (int j = 0; j < count.size(); j++) {
			while (count[j]-- > 0) {
				arr1[i++] = j;
			}
		}

		return arr1;
	}
};

#endif // _RELATIVESORTARRAY_H_
