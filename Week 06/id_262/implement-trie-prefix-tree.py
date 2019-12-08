class Trie(object):

    def __init__(self):
        self.root = {}
        self.end_of_word = "#"

    def insert(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word

    def search(self, word):
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self.end_of_word in node

    def startsWith(self, prefix):
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True


if __name__ == '__main__':
    trie = Trie()
    # trie.search("abc")
    # trie.insert("abc")
    # print(trie.root)

    trie.insert("apple")
    trie.search("apple")
    trie.search("app")
    trie.startsWith("app")
    trie.insert("app")
    trie.search("app")
