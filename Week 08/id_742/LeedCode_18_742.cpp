class Solution {
public:
    int count = 0;
    bool validPalindrome(string s) 
    {
        int left = 0;
        int right = s.size() - 1;
        while (left <= right) {
            if (s[left] != s[right]) {
                if (count < 1) {
                    count++;
                    return (validPalindrome(s.substr(left, (right - left))) || validPalindrome(s.substr(left + 1, (right - left))));
                } else {
                    return false;
                }  
            }
            left++;
            right--;
        }
        return true;
    }
};