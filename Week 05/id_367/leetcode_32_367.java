//暴力破解
//暴力破解官方会提示超时
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
//动态规划
//分为两种情况，当前字符为），和前一个字符为）
class Solution {
    public int longestValidParentheses(String s) {
        int maxans=0;
        int dp [] = new int[s.length()];
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = ((i >= 2 ) ?dp[i-2] : 0) + 2;  
                }
                if(i - dp[i-1] >0 && s.charAt(i - dp[i-1]-1)=='('){
                    dp[i] = dp[i-1] + ((i-dp[i-1] >= 2) ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
}