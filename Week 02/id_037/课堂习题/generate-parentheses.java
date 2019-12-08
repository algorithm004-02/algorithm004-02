// https://leetcode-cn.com/problems/generate-parentheses/
class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        int left = 0;
        int right = 0;
        String curr = "";
        helper(n, left, right, curr, res);
        return res;
    }
    private void helper(int n, int left, int right, String curr, List<String> res) {
        if (left + right == 2 * n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            helper(n, left++, right, curr + "(", res);
        }
        if (right < left) {
            helper(n, left, right++, curr+")", res);
        }
    }
}