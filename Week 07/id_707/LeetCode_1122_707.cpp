#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;
// 数组的相对排序
vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
	int pool[1001] = { 0 };
	vector<int> output;

	for (int i = 0; i < arr1.size(); i++) {

		pool[arr1[i]]++;
	}

	for (int i = 0; i < arr2.size(); i++) {

		for (int j = 0; j < pool[arr2[i]]; j++) {

			output.push_back(arr2[i]);
		}

		pool[arr2[i]] = 0;
	}

	for (int i = 0; i < 1001; i++) {

		while (pool[i]-- > 0) {

			output.push_back(i);
		}
	}


	return output;
}
int main() {
	vector<int> arr1 = { 2,3,1,3,2,4,6,7,9,2,19 };
	vector<int> arr2 = { 2,1,4,3,9,6 };
	vector<int> output = relativeSortArray(arr1,arr2);
	for (int i:output)
	{
		printf(" %d",i);
	}
	system("pause");
	return 0;
}