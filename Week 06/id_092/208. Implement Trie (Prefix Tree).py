#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/18 下午1:57
@Author : Catherinexxx
@Site : 
@File : 208. Implement Trie (Prefix Tree).py
@Software: PyCharm
"""


# class Trie(object):

# 	def __init__(self):
# 		self.root = {}
# 		self.end_of_word = "#"

# 	def insert(self, word):
# 		node = self.root
# 		for char in word:
# 			node = node.setdefault(char, {})
# 		node[self.end_of_word] = self.end_of_word

# 	def search(self, word):
# 		node = self.root
# 		for char in word:
# 			if char not in node:
# 				return False
# 			node = node[char]
# 		return self.end_of_word in node

# 	def startsWith(self, prefix):
# 		node = self.root
# 		for char in prefix:
# 			if char not in node:
# 				return False
# 			node = node[char]
# 		return True

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        tree = self.lookup
        for a in word:
            if a not in tree:
                tree[a] = {}
            tree = tree[a]
        # 单词结束标志
        tree["#"] = "#"

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        tree = self.lookup
        for a in word:
            if a not in tree:
                return False
            tree = tree[a]
        if "#" in tree:
            return True
        return False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        tree = self.lookup
        for a in prefix:
            if a not in tree:
                return False
            tree = tree[a]
        return True
