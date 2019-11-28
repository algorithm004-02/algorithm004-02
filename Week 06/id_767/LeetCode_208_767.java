package algorithm.LeetCode;

import java.util.HashMap;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/26
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
 */
public class _208_Trie {

  /**
   * 模板
   *
   * Python版
   * class Trie(object):
   *
   * 	def __init__(self):
   * 		self.root = {}
   * 		self.end_of_word = "#"
   *
   * 	def insert(self, word):
   * 		node = self.root
   * 		for char in word:
   * 			node = node.setdefault(char, {})
   * 		node[self.end_of_word] = self.end_of_word
   *
   * 	def search(self, word):
   * 		node = self.root
   * 		for char in word:
   * 			if char not in node:
   * 				return False
   * 			node = node[char]
   * 		return self.end_of_word in node
   *
   * 	def startsWith(self, prefix):
   * 		node = self.root
   * 		for char in prefix:
   * 			if char not in node:
   * 				return False
   * 			node = node[char]
   * 		return True
   *
   * */


  private TrieNode root;

  public _208_Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!node.containsKey(currentChar)) {
        node.put(currentChar, new TrieNode());
      }
      node = node.get(currentChar);
    }
    node.setEnd();
  }


  // returns the node where search ends
  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char curLetter = word.charAt(i);
      if (node.containsKey(curLetter)) {
        node = node.get(curLetter);
      } else {
        return null;
      }
    }
    return node;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }
}

class TrieNode {

  // R links to node children
  private TrieNode[] links;

  private final int R = 26;

  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[R];
  }

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public void setEnd() {
    isEnd = true;
  }

  public boolean isEnd() {
    return isEnd;
  }
}
/*

  作者：LeetCode
  链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/




}
