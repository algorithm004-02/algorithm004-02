package datastruct.recur;

import java.util.LinkedList;
import java.util.List;

/**
 *   22 括号生成
 *   给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     例如，给出 n = 3，生成结果为：
     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
 */
public class GenerateParentheses {

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        _generate(0,0,n,"");
        return result;
    }

    // left 随时加，只要超标
    // right 必须要之前右左括号垫背，
    // 且左个数 > 右个数
    private void _generate(int left, int right,int n, String s) {
        // terminator
        if (left == n && right == n) {
            // filter the invalid s
            System.out.println(s);
            result.add(s);
            return;
        }

        // process current logic:left,right

        // drill down
        if (left < n) {
            _generate(left + 1,right,n,s + "(");
        }
        if (left > right) {
            _generate(left,right + 1,n,s + ")");
        }
        // reverse states
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }


}
