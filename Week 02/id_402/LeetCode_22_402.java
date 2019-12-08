class Solution {// follow teacher
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        combe(0,0, n, "");
        return list;
    }

    //递归
    private void combe(int l, int r, int max, String s) {
        if (r == max && l == max) {
            list.add(s);
            return ;
        }
        if (l < max) {
            combe(l + 1, r ,max, s+"(");
        }
        if (r < l) {
            combe(l , r + 1 ,max, s+")");
        }
    }
}