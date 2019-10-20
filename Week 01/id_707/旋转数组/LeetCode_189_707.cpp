#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;

void reverse(vector<int> &arr, int start, int end) {
	while (start < end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		++start;
		--end;
	}
}

void rorate(vector<int> &arr, int k) {
	k %= arr.size();
	reverse(arr, 0, arr.size() - 1);
	reverse(arr, 0, k - 1);
	reverse(arr, k, arr.size() - 1);
}

void showArr(vector<int> arr) {
	for (int i = 0; i < arr.size(); ++i) {
		cout << " "<<arr[i]; 
	}
	cout << endl;
}

int main() {
	vector<int> arr = { 1,2,3,4,5,6,7 };
	int k = 3;
	rorate(arr, k);
	showArr(arr);
	system("pause");
	return 0;
}