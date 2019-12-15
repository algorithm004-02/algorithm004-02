import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，
 * 找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class LeetCode_438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		HashMap<Character, Integer> hashMap1 = new HashMap<>();
		HashMap<Character, Integer> hashMap2 = new HashMap<>();
		for (char c:p.toCharArray()) {
			hashMap1.put(c, hashMap1.getOrDefault(c, 0)+1);
		}

		int left=0, right=0, match=0;
		while (right < s.length()) {
			char currentChar = s.charAt(right);
			if (hashMap1.containsKey(currentChar)) {
				hashMap2.put(currentChar, hashMap2.getOrDefault(currentChar, 0)+1);
				if (hashMap2.get(currentChar).equals(hashMap1.get(currentChar))) {
					match++;
				}
			}
			right++;
			while (match == hashMap1.size()) {
				if (right-left == p.length()) {
					res.add(left);
				}
				char c2 = s.charAt(left);
				if (hashMap1.containsKey(c2)) {
					hashMap2.put(c2, hashMap2.get(c2)-1);
					if (hashMap2.get(c2) < hashMap1.get(c2)) {
						match--;
					}
				}
				left++;
			}
		}
		return res;
	}

	public List<Integer> findAnagramsV1(String s, String p) {
		if (s == null || s.length() == 0) return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		int[] needs = new int[26];
		int[] window = new int[26];
		int left=0, right=0, total=p.length();

		for (char c:p.toCharArray()) {
			needs[c-'a']++;
		}
		while (right < s.length()) {
			char currentChar = s.charAt(right);
			if (needs[currentChar-'a'] > 0) {
				window[currentChar-'a']++;
				if (window[currentChar-'a'] <= needs[currentChar-'a']) {
					total--;
				}
			}
			while (total == 0) {
				if (right-left+1 == p.length()) {
					res.add(left);
				}
				char ch1 = s.charAt(left);
				if (needs[ch1-'a'] > 0) {
					window[ch1-'a']--;
					if (window[ch1-'a'] < needs[ch1-'a']) {
						total ++;
					}
				}
				left++;
			}
			right++;
		}
		return res;
	}
}
