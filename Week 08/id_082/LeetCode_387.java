import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 */
public class LeetCode_387 {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> count = new HashMap<>();
		for (char c:s.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0)+1);
		}

		for (int i=0; i<s.length(); i++) {
			if (count.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqCharV1(String s) {
		int[] freq = new int[26];
		for (int i=0; i<s.length(); i++) freq[s.charAt(i)-'a']++;
		for (int i=0; i<s.length(); i++) {
			if (freq[s.charAt(i)-'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqCharV2(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i=0; i<s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				if (map.get(s.charAt(i)) != null) {
					map.remove(s.charAt(i));
				}
			} else {
				map.put(s.charAt(i), i);
				set.add(s.charAt(i));
			}
		}
		return map.size() == 0 ? -1:map.entrySet().iterator().next().getValue();
	}
}
