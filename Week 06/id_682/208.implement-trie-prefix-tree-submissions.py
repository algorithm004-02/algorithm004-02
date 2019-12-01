class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.results = {}
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        t = self.results

        for s in word:
            if not s in t:
                t[s] = {}
            t = t[s]
        t['end'] = True
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        t = self.results

        for s in word:
            if not s in t:
                return False
            t = t[s]
        
        if 'end' in t:
            return True
        return False
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        t = self.results

        for s in prefix:
            if not s in t:
                return False
            t = t[s]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)