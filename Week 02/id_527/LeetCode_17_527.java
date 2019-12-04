/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    Map<String, String> phone = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
        combinations("", digits);
        return result;
    }

    void combinations(String prefix, String digits) {
        if (digits == null || digits.length() == 0) {
            result.add(prefix);
            return;
        }
        String first = String.valueOf(digits.charAt(0));
        String letters = phone.get(first);
        for (char c : letters.toCharArray()) {
            combinations(prefix + c, digits.substring(1));
        }
    }
}
// @lc code=end
