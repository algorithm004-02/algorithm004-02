#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <string>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

// ×ÖÄ¸ÒìÎ»´Ê·Ö×é
vector<vector<string>> groupAnagrams(vector<string>& strs) {
	vector<vector<string>> res;
	map<string, vector<string>> ma;
	for (auto str:strs)
	{
		string temp = str;
		sort(temp.begin(), temp.end());
		ma[temp].push_back(str);
	}

	for (auto &m : ma)
	{
		res.push_back(m.second);
	}
	return res;
}

int main() {
	vector<string> strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
	vector<vector<string>> res = groupAnagrams(strs);

	system("pause");
	return 0;
}