class LeetCode_17_487{

    /***
     *
     * 17题目
     *
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     * @return
     */
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        return find1(new ArrayList<String>(), "", digits);
    }

    /**
     * @param strs        存放的结果数据
     * @param combination 组合的字符串
     * @param digits      剩下的输入数字
     * @return
     */
    private List<String> find1(ArrayList<String> strs, String combination, String digits) {
        //1.递归终止条件
        if (digits.length() == 0) {
            strs.add(combination);
            return strs;
        }
        //取出第一个输入的数字（假设最开始输入的是23， 这里 例如是 2 ）
        String substring = digits.substring(0, 1);
        //根据第一个输入的数字找到对应的键盘字符串（如果是这，这里就是 abc ）
        String phoneStr = phone.get(substring);
        //2.处理当前层逻辑   3.下到下一层
        for (int i = 0; i < phoneStr.length(); i++) {
            //取出单个字符（如果是2，这里是 a 或者 b 或者 c ）
            String letter = phoneStr.substring(i, i + 1);
            //递归去接下来剩余的数字（ 3 ）
            find1(strs, combination + letter, digits.substring(1));
        }
        return strs;
    }
}