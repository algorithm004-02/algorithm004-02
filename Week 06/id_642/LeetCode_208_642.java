package week6;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/21 07:12 https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class L208 {
  /**
   * implement Trie
   * */

  TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public L208() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode trieNode = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!trieNode.containsKey(c)) {
        trieNode.put(c, new TrieNode());
      }
      trieNode = trieNode.get(c);
    }
    trieNode.end();
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode trieNode = searchPrefix(word);
    return trieNode != null && trieNode.isEnd();
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode trieNode = searchPrefix(prefix);
    return trieNode != null;
  }

  public TrieNode searchPrefix(String prefix) {
    TrieNode trieNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!trieNode.containsKey(c)) {
        return null;
      }
      trieNode = trieNode.get(c);
    }
    return trieNode;
  }

  class TrieNode {

    private TrieNode[] links;

    private int r = 26;

    private boolean isEnd;

    public TrieNode() {
      links = new TrieNode[r];
    }

    public boolean containsKey(char c) {
      TrieNode trieNode = links[c - 'a'];
      return trieNode != null;
    }

    public void end() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }

    public void put(char c, TrieNode trieNode) {
        links[c - 'a'] = trieNode;
    }

    public TrieNode get(char c) {
      return links[c - 'a'];
    }
  }

}
