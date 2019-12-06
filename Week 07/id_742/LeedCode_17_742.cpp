class Solution {
public:
    string reverseStr(string s, int k) {
        int cnt = 0;
        string res = "", tmp = "";
        for(int i=0;i<s.length();i++)
        {
            if(i % k == 0)      
            {
                cnt++;
                res += tmp;
                tmp = "";
            }
            if(cnt % 2 == 1)        // 第奇数个K子串，逆序
                tmp = s[i] + tmp;
            else
                tmp = tmp + s[i];   // 第偶数个K子串，正序
        }
        return res + tmp;
    }
};
