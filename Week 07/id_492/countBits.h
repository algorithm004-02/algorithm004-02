#ifndef _COUNTBITS_H_
#define _COUNTBITS_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> countBits(int num) {
		vector<int> res(num + 1, 0);
		for (int i = 0; i <= num; i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}
};

#endif // _COUNTBITS_H_
