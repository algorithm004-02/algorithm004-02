#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;
// 位1的个数
int hammingWeight(uint32_t n) {
	int m = 0;
	for (;n;m++)
		n &= n - 1;
	return m;
}
int main() {
	uint32_t n = 00000000000000000000000000001011;
	printf("1的个数==%d\n", hammingWeight(n));
	system("pause");
	return 0;
}