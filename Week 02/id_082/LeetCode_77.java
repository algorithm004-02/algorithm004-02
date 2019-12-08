import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode-77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 */

class Solution {
	private List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		if (n<=0 || k<=0 || n < k) return result;

		findCombinations(n, k, 1, new Stack<>());
		return result;
	}

	private void findCombinations(int n, int k, int start, Stack<Integer> pre) {
		if (pre.size() == k) {
			result.add(new ArrayList<>(pre));
			return ;
		}

		for (int i = start; i <= n; i++) {
			pre.add(i);
			findCombinations(n, k, i+1, pre);
			pre.pop();
		}
	}
}