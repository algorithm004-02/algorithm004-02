#ifndef _GROUPANAGRAMS_H_
#define _GROUPANAGRAMS_H_

#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mapgroups;
        vector<vector<string>> result;

        for (auto& str : strs) {
            string strtmp = str;
            sort(strtmp.begin(), strtmp.end());
            mapgroups[strtmp].push_back(str);
        }

        for (auto& group : mapgroups) {
            result.push_back(group.second);
        }

        return result;
    }
};

#endif