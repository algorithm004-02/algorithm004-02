#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int numDecodings(string s) {
    	if (s[0] == '0') {
    		return 0;
    	}
    	
    	int len = s.size();
    	int pre = 1, curr = 1;
    	for (int i = 1; i < len; i++) {
    		int temp = curr;
    		if(s[i] == '0') {
    			if (s[i - 1] == '1' || s[i - 1] == '2') {
    				curr = pre;
    			}
    			else {
    				return 0;
    			}
    		}
    		else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')) {
    			curr += pre;
        }
    		pre = temp;
    	}
    	return curr;
    }
};