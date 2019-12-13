#ifndef _MERGEINTERVALS_H_
#define _MERGEINTERVALS_H_

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<vector<int>> merge(vector<vector<int>>& intervals) {
		vector<vector<int>> res;
		if (intervals.empty()) {
			return res;
		}

		sort(intervals.begin(), intervals.end(), cmp);
		res.push_back(intervals[0]);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals[i].front() <= res.back().back()) {
				vector<int> temp{ res.back().front(), max(intervals[i].back(), res.back().back()) };
				res.pop_back();
				res.push_back(temp);
			}
			else {
				res.push_back(intervals[i]);
			}
		}
		return res;
	}

private:
	static bool cmp(vector<int>& a, vector<int>& b) {
		return a.front() < b.front();
	}
};

#endif // _MERGEINTERVALS_H_
