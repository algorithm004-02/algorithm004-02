class Solution {
    
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return res;
    }

    private void  _generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        // process

        // drill down
        // 左括号个数小于n时才能加
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        // 只有左括号大于右括号的个数时，才可以加右括号
        if (right < left) {
            _generate(left, right + 1, n, s + ")");
        }

        // reverse states
    }
}