//[77]组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    private List<List<Integer>> all = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return Collections.emptyList();
        }
        all.clear();
        combine(n, k, Collections.emptyList());
        return all;
    }

    private void combine(int n, int k, List<Integer> last) {

        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> result = new LinkedList<>(last);
                result.add(i);
                all.add(result);
            }
            return;
        }

        if (n == k) {
            List<Integer> result = new LinkedList<>(last);
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            all.add(result);
            return;
        }

        for (int i = n; i >= k; i--) {
            List<Integer> curr = new LinkedList<>(last);
            curr.add(i);
            combine(i - 1, k - 1, curr);
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
        if (!"[[4, 1], [4, 2], [4, 3], [3, 1], [3, 2], [2, 1]]".equals(result.toString())) {
            throw new AssertionError("case1");
        }
    }
}