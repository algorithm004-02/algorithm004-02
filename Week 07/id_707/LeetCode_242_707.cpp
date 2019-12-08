#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <stack>
#include <iostream>
#include <algorithm>
using namespace std;

// “ÏŒª¥ 
bool isAnagram(string s, string t) {
	if (s.length() != t.length()) return false;

	sort(s.begin(),s.end());
	sort(t.begin(), t.end());
	return s == t;
}

int main() {
	string str = "addceedd";
	string str1 = "addddcea";
	cout << isAnagram(str, str1) << endl;
	system("pause");
	return 0;
}