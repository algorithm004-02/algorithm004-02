package com.tulane.mine;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("13");
        System.out.println(JSON.toJSON(strings));
    }

    /**
     * 第一种
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.trim().equals("")) return new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', Arrays.asList("*"));
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        char[] digitsArr = digits.toCharArray();

        List<String> strArr = new ArrayList<>();
        _letterCombinations(strArr, digitsArr, map, 0, "");
        return strArr;
    }

    private void _letterCombinations(List<String> strArr, char[] digitsArr, Map<Character, List<String>> map, int i, String str) {
        if (i >= digitsArr.length) {
            strArr.add(str);
            return;
        }

        List<String> list = map.get(digitsArr[i]);
        for (String s : list) {
            _letterCombinations(strArr, digitsArr, map, i + 1, str + s);
        }
    }


}
