package com.study.week6.lesson14;

import com.study.week6.lesson13.Solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_482 {

    /**
     * dfs
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        // 递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left, right - 1, res);
        }
    }

}
