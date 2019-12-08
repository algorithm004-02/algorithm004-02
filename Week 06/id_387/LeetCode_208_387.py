# https://leetcode.com/problems/implement-trie-prefix-tree/
# 208. Implement Trie (Prefix Tree)
class Trie:

  def __init__(self):
    """
    Initialize your data structure here.
    """
    self.root = {}
    self.end_of_word = "#"


  def insert(self, word: str) -> None:
    """
    Inserts a word into the trie.
    """
    node = self.root
    for ch in word:
      node = node.setdefault(ch, {})
    node[self.end_of_word] = self.end_of_word

  def search(self, word: str) -> bool:
    """
    Returns if the word is in the trie.
    """
    node = self.root
    for ch in word:
      if ch not in node: return False
      node = node[ch]
    return self.end_of_word in node

  def startsWith(self, prefix: str) -> bool:
    """
    Returns if there is any word in the trie that starts with the given prefix.
    """
    node = self.root
    for ch in prefix:
      if ch not in node: return False
      node = node[ch]
    return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)