#ifndef _FIRSTUNIQCHAR_H_
#define _FIRSTUNIQCHAR_H_

#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
	int firstUniqChar(string s) {
		int len = s.size();
		unordered_map<char, int> hashmap(len, 0);
		for (int i = 0; i < len; i++) {
			hashmap[s[i]]++;
		}
		for (int i = 0; i < len; i++) {
			if (hashmap[i] == 1) {
				return i;
			}
		}
		return -1;
	}
};

#endif // _FIRSTUNIQCHAR_H_
