//[17]电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    private final static Map<Character, String> CHARS = new HashMap<>();
    static {
        CHARS.put('2', "abc");
        CHARS.put('3', "def");
        CHARS.put('4', "ghi");
        CHARS.put('5', "jkl");
        CHARS.put('6', "mno");
        CHARS.put('7', "pqrs");
        CHARS.put('8', "tuv");
        CHARS.put('9', "wxyz");
    }

    private final static List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        result.clear();
        generate("", digits, 0);
        return result;
    }

    public void generate(String curr, String digits, int i) {

        if (i == digits.length()) {
            result.add(curr);
            return;
        }

        String chars = CHARS.get(digits.charAt(i));
        for (int j = 0; j < chars.length(); j++) {
            generate(curr + chars.charAt(j), digits, i + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
        if (!"[ad, ae, af, bd, be, bf, cd, ce, cf]".equals(result.toString())) {
            throw new AssertionError("case1");
        }
    }
}