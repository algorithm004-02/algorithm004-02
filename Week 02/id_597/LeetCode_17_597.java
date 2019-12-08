import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * Created by yangwenwei on 2019/10/27.
 */
public class LeetCode_17_597 {
    class Solution {
        //类似括号问题22
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.isEmpty()) return res;
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            recursion(0, "", digits, res, map);
            return res;
        }

        private void recursion(int i, String s, String digits, List<String> res, Map<Character, String> map) {
            //terminator
            if (i == digits.length()) {
                res.add(s);
                return;
            }
            //process
            //drill down
            String letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.length(); j++) {
                recursion(i + 1, s + letters.charAt(j), digits, res, map);
            }

            //revert state
        }
    }
}
