#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <stack>
#include <iostream>
#include <algorithm>
using namespace std;

// “ÏŒª¥ 
bool isAnagram(string s, string t) {
	if (s == t) return true;
	if (s.length() != t.length()) return false;

	vector<int> arr(26);
	for (int i = 0; i < s.length(); ++i)
	{
		arr[s[i] - 'a']++;
		arr[t[i] - 'a']--;
	}
	for (int i = 0; i<arr.size(); ++i)
	{
		if (arr[i] != 0)
			return false;
	}
	return true;
}

int main() {
	string str = "addceedd";
	string str1 = "addddcea";
	cout << isAnagram(str, str1) << endl;
	system("pause");
	return 0;
}