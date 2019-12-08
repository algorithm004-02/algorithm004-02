import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * Created by yangwenwei on 2019/10/27.
 */
public class LeetCode_77_597 {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            recursion(1, n, k, new LinkedList<>(), result);
            return result;
        }

        private void recursion(int i, int n, int k, LinkedList<Integer> cur, List<List<Integer>> result) {
            //terminator
            if (cur.size() == k) result.add(new LinkedList<>(cur));
            //
            for (int j = i; j < n + 1; j++) {
                cur.add(j);
                //drill down
                recursion(j + 1, n, k, cur, result);
                //revert state
                cur.removeLast();
            }
        }
    }
}
