/**
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 * <p>
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 * <p>
 * 输入: "LOVELY"
 * 输出: "lovely"
 */

class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}