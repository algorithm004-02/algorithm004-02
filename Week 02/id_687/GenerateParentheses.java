package com.itliusir.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * problem.22
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author liugang
 * @date 2019-10-27
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> strings = new GenerateParentheses().generateParenthesis(3);
        strings.forEach(s -> System.out.println(s));
    }

    /**
     * method 1 -> time O(>2^n) space O(n)
     *
     * 递归解法
     * 通过限定条件 1. 左括号数量等于n 2. 右括号数量等于左括号数量
     *
     * @author liugang
     * @date 2019-10-27 14:53:24
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doGenerateParenthesis(result, 0, 0, n, "");
        return result;
    }

    private void doGenerateParenthesis(List<String> result, int left, int right, int n, String str) {
        if (left == n && right == left) {
            result.add(str);
            return;
        }
        if (left < n) {
            doGenerateParenthesis(result, left + 1, right, n, str + "(");
        }
        if (right < left) {
            doGenerateParenthesis(result, left, right + 1, n, str + ")");
        }

    }


}

