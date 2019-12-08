class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {

        String s = "";
        result = new ArrayList<>();
        _generator(0, 0, n, "");

        return result;
    }

    private void _generator(int left, int right, int n, String s) {

        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            _generator(left + 1, right, n, s + "(");
        }

        if (right < left) {
            _generator(left, right + 1, n, s + ")");
        }
    }
}