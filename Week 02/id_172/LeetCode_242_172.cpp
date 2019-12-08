class Solution {
public:
    bool isAnagram(string s, string t) {
        int size = (int)s.length();
        vector<int> hash(26, 0);
        for (int i = 0; i < size; i++) {
            hash[s[i]-'a']++;
        }
        size = (int) t.length();
        for (int i = 0; i < size; i++) {
            hash[t[i]-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
};

// 1. 暴力破解
// 对字符串中所有字符进行排序，比较排序后对字符串是不是相同
// class Solution {
// public:
//     bool isAnagram(string s, string t) {
//         sort(s.begin(), s.end());
//         sort(t.begin(), t.end());
//         return s == t;
//     }
// };
// 2. hash表 统计每个字母出现的次数，查看是否相同