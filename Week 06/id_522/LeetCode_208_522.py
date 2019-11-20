class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root={}
        self.end="#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node=self.root
        for w in word:
            node=node.setdefault(w,{})
        node["#"]="#"

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node=self.root
        for w in word:
            if w not in node:return False
            node=node[w]
        return "#" in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node=self.root
        for w in prefix:
            if w not in node:return False
            node=node[w]
        return True      
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
