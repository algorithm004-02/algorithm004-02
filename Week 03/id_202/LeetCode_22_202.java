package com.algorithm.qinchao.homework.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/1 14:43
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_202 {
    public static List<String> generateParenthesisByBFS(int n) {
        String start = "(";
        List<String> result = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String temp = queue.poll();
                if (temp.length() < n * 2) {
                    getNext(temp, queue);
                } else {
                    if (isValid(temp)) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    private static void getNext(String curr, LinkedList<String> queue) {
        String newStr = curr + "(";
        String newStr2 = curr + ")";
        queue.add(newStr);
        queue.add(newStr2);
    }

    private static boolean isValid(String newStr) {
        int balance = 0;
        for (int i = 0; i < newStr.length(); i++) {
            if (newStr.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    public static List<String> generateParenthesisByDFS(int n) {
        List<String> result = new ArrayList<>();
        recursive("", n, 0, 0, result);
        return result;
    }

    private static void recursive(String str, int max, int open, int close, List<String> result) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (open < max) {
            recursive(str + "(", max, open + 1, close, result);
        }
        if (open > close) {
            recursive(str + ")", max, open, close + 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_22_202.generateParenthesisByBFS(3));
        System.out.println(LeetCode_22_202.generateParenthesisByDFS(3));
    }
}
