class Solution {
    Map<String, String[]> phone = new HashMap<String, String[]>() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    List<String> output = new ArrayList<String>();
    int num;
    String dig;

    public List<String> letterCombinations(String digits) {
        if (!"".equals(digits)) {
            this.dig = digits;
            num = digits.length();
            getAllStr(digits, new Stack<>(), digits.substring(0, 1), 0);
        }
        return output;
    }

    private void getAllStr(String digits, Stack<String> combine, String key, int index) {

        if (combine.size() == num) {
            String str = combine.get(0);
            for (int i = 1; i < combine.size(); i++) {
                str += combine.get(i);
            }
            output.add(str);
            return;
        }

        for (int i = 0; i < phone.get(key).length; i++) {
            combine.add(phone.get(key)[i]);
            if (index < num - 1) {
                getAllStr(digits, combine, dig.substring(++index, index + 1), index);
            } else {
                getAllStr(digits, combine, "", index);

            }
            combine.pop();
            index--;
        }
    }

}