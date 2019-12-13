#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
#include <unordered_map>
using namespace std;
// 字符串中第一个唯一的一个字符
int firstUniqChar(string s) {
	unordered_map<char, int> hasmap;
	for (char i :s)
	{
		hasmap[i]++;
	}
	for (int i = 0; i < s.size(); ++i)
	{
		if (hasmap[s[i]] == 1)
		{
			return i;
		}
	}
	return -1;
}
int main() {
	string s = "loveleetcode";
	printf("字符索引=%d\n",firstUniqChar(s));
	system("pause");
	return 0;
}