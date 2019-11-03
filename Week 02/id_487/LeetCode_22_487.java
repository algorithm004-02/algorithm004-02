class LeetCode_22_487{

    /***
     *
     * 22题
     *
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> aa = new ArrayList<String>();
        back(aa, "", 0, 0, n);
        return aa;
    }

    public static void back(List<String> strs, String str, int ln, int rn, int n) {
        //左右括号都用完就结束
        if (ln == n && rn == n) {
            strs.add(str);
            return;
        }

        //条件1:左括号小于总长度先放左括号
        //条件2:右括号少于左括号可以放右括号
        if (ln < n) {
            back(strs, str + "(", ln + 1, rn, n);
        }
        if (rn < ln) {
            back(strs, str + ")", ln, rn + 1, n);
        }
    }
}