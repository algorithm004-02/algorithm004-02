class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if (0 == strs.size()) return {};
        map<string, vector<string>> _map;
        for (auto s : strs) {
            string t = s;
            sort(t.begin(), t.end());
            _map[t].push_back(s);
        }
        vector<vector<string>> _str;
        for (auto s : _map) {
            _str.push_back(s.second);
        }
        return _str;
    }
};