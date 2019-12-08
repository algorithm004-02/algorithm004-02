#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;
// 2µÄÃÝ
bool isPowerOfTwo(int n) {
	if (n <= 0) return false;
	return (n&(n - 1)) == 0;
}
int main() {
	int n = 12;
	printf("2µÄÃÝ==%d\n", isPowerOfTwo(n));
	system("pause");
	return 0;
}