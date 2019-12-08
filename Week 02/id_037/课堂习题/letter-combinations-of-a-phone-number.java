import java.util.HashMap;
import java.util.List;

// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> res = new ArrayList();
        helper("",map, digits, 0, res);
        return res;
    }
    private void helper(String str, Map map, String digits, int pos, List<String> res) {
        if (pos >= digits.length()) {
            res.add(str);
            return;
        }
        String chars = map.get(digits.charAt(pos));
        for (int i = 0; i < chars.length(); i++) {
            helper(str + chars.charAt(i), map, digits, pos + 1, res);
        }
    }
}