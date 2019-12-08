/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @version v1.0
 */
class Trie {

	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c-'a'] == null) {
				node.children[c-'a'] = new TrieNode();
			}
			node = node.children[c-'a'];
		}
		node.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = SearchPrefix(word);
		return node != null && node.isEnd;
	}

	/**
	 * search a prefix or whole key in trie and returns the node where search ends
	 * @param word
	 * @return
	 */
	private TrieNode SearchPrefix(String word) {
		TrieNode node = root;
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c-'a'] != null) {
				node = node.children[c-'a'];
			} else {
				return null;
			}
		}
		return node;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node = SearchPrefix(prefix);
		return node != null;
	}
}

class TrieNode {
	public TrieNode[] children;
	public boolean isEnd;

	public TrieNode() {
		children = new TrieNode[26];
	}
}