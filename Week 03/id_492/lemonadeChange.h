#ifndef _LEMONADECHANGE_H_
#define _LEMONADECHANGE_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	bool lemonadeChange(vector<int>& bills) {
		int five = 0, ten = 0;
		for (int i : bills) {
			if (i == 5) five++;
			else if (i == 10) five--, ten++;
			else if (ten > 0) ten--, five--;
			else five -= 3;
			if (five < 0) return false;
		}
		return true;
	}
};

#endif
