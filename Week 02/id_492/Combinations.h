#ifndef _COMBINATIONS_H_
#define _COMBINATIONS_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return ans;
        }

        vector<int> path;
        dfs(n, k, 1, path);
        return ans;
    }

private:
    void dfs(int n, int k, int start, vector<int> &path) {
        if (path.size() == k) {
            ans.push_back(path);
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; ++i) {
            path.push_back(i);
            dfs(n, k, i + 1, path);
            path.pop_back();

        }
    }

private:
    vector<vector<int>> ans;
};

#endif
