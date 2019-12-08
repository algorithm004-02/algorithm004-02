#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;
// 解码方法
int numDecodings(string s) {
	if (s[0] == '0')
		return 0;
	int pre = 1;
	int curr = 1;
	for (int i = 1; i <s.size(); ++i)
	{
		int tmp = curr;
		if (s[i] == '0')
		{
			if (s[i - 1] == '1' || s[i - 1] == '2')
				curr = pre;
			else
				return 0;
		}
		else if(s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '1' && s[i] <= '6'))
		{
			curr += pre;
		}
		pre = tmp;
	}
	return curr;
}

int main() {
	string s = "226";
	printf("解码总数:%d\n", numDecodings(s));
	system("pause");
	return 0;
}