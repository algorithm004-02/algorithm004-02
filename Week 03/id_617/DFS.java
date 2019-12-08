/**
 * 	DFS递归代码模版
 * 	visited = set() 
	def dfs(node, visited):
	if node in visited: # terminator
		# already visited 
		return 

		visited.add(node) 

		# process current node here. 
		...
		for next_node in node.children(): 
			if not next_node in visited: 
				ssdfs(next_node, visited)
 */
package id_617;

import java.util.HashSet;
import java.util.Set;

/**
 * 433.最小基因
 * 一条基因序列由一个带有8个字符的字符串表示，
 * 其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。
 * 一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 
 * 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，
 * 都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，
 * 分别代表起始基因序列，目标基因序列及基因库，
 * 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。
 * 如果无法实现目标变化，请返回 -1。
 * 
 * 
 * 整体不是很理解吧。。。以待后续
 */
public class DFS {
	
	public int minMutation(String start, String end, String[] bank) {
		Set<String> set = new HashSet<>();
		// 将基因库的重复内入去除		
		for (String s : bank) {
			set.add(s);
		}
		int res = dfs(start, end, set, 0);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int diff(String s1, String s2) {
		int res = 0;
		for (int i = 0; i < 8; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				res++;
		}
		return res;
	}

	private int dfs(String start, String end, Set<String> bank, int depth) {
		// 比对基因是否一致
		if (start.equals(end))
			return depth;
		int res = Integer.MAX_VALUE;
		// ？若基因库为空，则有很多种？
		if (bank.isEmpty())
			return res;
		for (String s : bank) {
			if (s.equals(end) && diff(s, start) == 1)
				return depth + 1;
			else if (diff(s, start) == 1) {
				Set<String> bank1 = new HashSet<>(bank);
				bank1.remove(s);
				res = Math.min(res, dfs(s, end, bank1, depth + 1));
			}
		}
		return res;
	}
}
