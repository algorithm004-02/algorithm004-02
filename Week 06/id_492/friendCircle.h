#ifndef _FRIENDCIRCLE_H_
#define _FRIENDCIRCLE_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int findCircleNum(vector<vector<int>>& M) {
		if (M.empty()) {
			return 0;
		}

		int num = M.size();
		vector<int> parents(num, 0);
		for (int i = 0; i < parents.size(); i++) {
			parents[i] = i;
		}

		int group = num;
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				if (!M[i][j]) {
					continue;
				}
				int root1 = find(i, parents);
				int root2 = find(j, parents);
				if (root1 != root2) {
					parents[root2] = root1;
					group--;
				}
			}
		}
		return group;
	}

private:
	int find(int n, vector<int>& parents) {
		return parents[n] == n ? n : find(parents[n], parents);
	}
};

#endif

