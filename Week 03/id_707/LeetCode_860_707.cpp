#include <stdlib.h>
#include <stdio.h>
#include<vector>
#include <iostream>
using namespace std;
// ÄûÃÊË®ÕÒÁã

bool lemonadeChange(vector<int>& bills) {
	int five = 0; 
	int ten = 0; 
	for (int i = 0; i < bills.size(); ++i)
	{
		int money = bills.at(i);
		switch (money)
		{
			case 5:
			{
				++five;
			}
			    break;
			case 10:
			{
				if (five == 0)
					return false;
				++ten;
				--five;
			} 
			    break;
			case 20:
			{
				if ( five >0 && ten > 0){
					--ten;
					--five;
				}
				else if ( five > 3){
					five -= 3;
				}
				else {
					return false;
				}
			}
			    break;
		}
	}
	return true;
}

int main() {
	vector<int> bills = {5,10,20};
	bool isOk = lemonadeChange(bills);
	printf("isok==%d", isOk);
	system("pause");
	return 0;
}