import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode-cn.com/problems/valid-parentheses/

// 辅助栈
// 遍历string，将开括号直接入栈，闭括号检查栈顶元素出栈并检查是否匹配，匹配关系写入一个hashmap
class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> ParenthesesPairs = new HashMap<Character, Character>();
        ParenthesesPairs.put(')','(');
        ParenthesesPairs.put(']','[');
        ParenthesesPairs.put('}','{');
    
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ParenthesesPairs.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (ParenthesesPairs.get(c) != top) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}