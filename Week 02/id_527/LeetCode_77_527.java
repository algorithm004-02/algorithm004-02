/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        combineNums(new LinkedList<>(), 1);
        return result;
    }

    void combineNums(LinkedList<Integer> list, int first) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i <= n; i++) {
            list.add(i);
            combineNums(list, i + 1);
            list.removeLast();
        }
    }
}
// @lc code=end
