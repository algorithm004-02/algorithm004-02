import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * @version v1.0
 */
public class LeetCode127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) return 0;
		if (beginWord.equals(endWord)) return 2;

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		HashMap<String, Boolean> visited = new HashMap<>();
		for (String word:wordList) visited.put(word, Boolean.FALSE);

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;

			while (size-- > 0) {
				String cur = queue.poll();
				for (String next:wordList) {
					if (visited.get(next)) {
						continue;
					}
					if (!match(cur, next)) {
						continue;
					}
					if (endWord.equals(next)) {
						return ++level;
					}
					queue.add(next);
					visited.put(next, true);
				}
			}
		}

		return 0;
	}

	private boolean match(String cur, String next) {
		int count = 0;
		for (int i=0; i<cur.length(); i++) {
			if (cur.charAt(i) != next.charAt(i)) {
				count++;
			}
			if (count>1) return false;
		}
		return count == 1;
	}
}
