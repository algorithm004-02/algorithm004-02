import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<String>();
		if (digits.length() == 0) {
			return result;
		}

		Map<Character, String> phone = new HashMap<Character, String>();
		phone.put('2', "abc");
		phone.put('3', "def");
		phone.put('4', "ghi");
		phone.put('5', "jkl");
		phone.put('6', "mno");
		phone.put('7', "pqr");
		phone.put('8', "tuv");
		phone.put('9', "wxyz");

		search("", digits, 0, result, phone);
		return result;
	}

	private void search(String s,
		String digits,
		int i,  // level, 回溯的层级
		List<String> result,
		Map<Character, String> phone) {
		if (i == digits.length()) {
			result.add(s);
			return ;
		}

		String letters = phone.get(digits.charAt(i));
		for (int j = 0; j < letters.length(); j++) {
			search(s+letters.charAt(j), digits, i+1, result, phone);
		}
	}
}
