#ifndef _SUNOFTWONUM_H_
#define _SUNOFTWONUM_H_

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hashmap;
        vector<int> result;

        for (int i = 0; i < nums.size(); i++) {
            int findnum = target - nums[i];

            if (hashmap.find(findnum) != hashmap.end()) {
                result.push_back(hashmap[findnum]);
                result.push_back(i);
            }
            hashmap[nums[i]] = i;
        }
        return result;
	}
};


#endif