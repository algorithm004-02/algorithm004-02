#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;
// ·­×ª×Ö·û´®
void reverse(string &s, int i, int j) {
	while (i < j )
	{
		swap(s[i], s[j]);
		i++;
		j--;
	}
}
string reverseStr(string s, int k) {
	for (int i = 0; i <s.length(); i++)
	{
		int j = i + k <= s.length() ? i + k - 1 : s.length() - 1;
		reverse(s, i, j);
		i = j + k;
	}
	return s;
}
int main() {
	string s = "abcdefg";
	printf("·­×ªºóµÄ×Ö·û´®%s\n", reverseStr(s,2).c_str());
	system("pause");
	return 0;
}