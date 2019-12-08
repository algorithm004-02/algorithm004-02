class Solution {
public:
	vector<vector<int>> res;
	int len;
	vector<int> tmp;
	vector<vector<int>> permute(vector<int>& nums) {
		len = nums.size();
		tmp = nums;
		dfs(0);
		return res;
	}

	void dfs(int deep) {
		if (deep == len-1) {
			res.push_back(tmp);
		}
		for (int i = deep; i < len; ++i) {
			int t = tmp[i]; 
			tmp[i] = tmp[deep];
			tmp[deep] = t;
			dfs(deep+1);
			tmp[deep] = tmp[i];
			tmp[i] = t;
		}
	}
};