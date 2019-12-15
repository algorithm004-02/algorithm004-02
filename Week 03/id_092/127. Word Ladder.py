#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/31 上午11:27
@Author : Catherinexxx
@Site : 
@File : 127. Word Ladder.py
@Software: PyCharm
"""
# # BFS
# from collections import defaultdict
# class Solution(object):
#     def ladderLength(self, beginWord, endWord, wordList):
#         """
#         :type beginWord: str
#         :type endWord: str
#         :type wordList: List[str]
#         :rtype: int
#         """

#         if endWord not in wordList or not endWord or not beginWord or not wordList:
#             return 0

#         # Since all words are of same length.
#         L = len(beginWord)

#         # Dictionary to hold combination of words that can be formed,
#         # from any given word. By changing one letter at a time.
#         all_combo_dict = defaultdict(list)
#         for word in wordList:
#             for i in range(L):
#                 # Key is the generic word
#                 # Value is a list of words which have the same intermediate generic word.
#                 all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

#         # defaultdict(<class 'list'>, {'*ot': ['hot', 'dot', 'lot'], 'h*t': ['hot'], 'ho*': ['hot'], 'd*t': ['dot'], 'do*': ['dot', 'dog'], '*og': ['dog', 'log', 'cog'], 'd*g': ['dog'], 'l*t': ['lot'], 'lo*': ['lot', 'log'], 'l*g': ['log'], 'c*g': ['cog'], 'co*': ['cog']})

#         # Queue for BFS
#         queue = [(beginWord, 1)]
#         # Visited to make sure we don't repeat processing same word.
#         visited = {beginWord: True}
#         while queue:
#             current_word, level = queue.pop(0)
#             for i in range(L):
#                 # Intermediate words for current word
#                 intermediate_word = current_word[:i] + "*" + current_word[i+1:]

#                 # Next states are all the words which share the same intermediate state.
#                 for word in all_combo_dict[intermediate_word]:
#                     # If at any point if we find what we are looking for
#                     # i.e. the end word - we can return with the answer.
#                     if word == endWord:
#                         return level + 1
#                     # Otherwise, add it to the BFS Queue. Also mark it visited
#                     if word not in visited:
#                         visited[word] = True
#                         queue.append((word, level + 1))
#                 all_combo_dict[intermediate_word] = []
#         return 0


# 双端BFS
from collections import defaultdict


class Solution(object):
    def __init__(self):
        self.length = 0
        # Dictionary to hold combination of words that can be formed,
        # from any given word. By changing one letter at a time.
        self.all_combo_dict = defaultdict(list)

    def visitWordNode(self, queue, visited, others_visited):
        current_word, level = queue.pop(0)
        for i in range(self.length):
            # Intermediate words for current word
            intermediate_word = current_word[:i] + "*" + current_word[i + 1:]

            # Next states are all the words which share the same intermediate state.
            for word in self.all_combo_dict[intermediate_word]:
                # If the intermediate state/word has already been visited from the
                # other parallel traversal this means we have found the answer.
                if word in others_visited:
                    return level + others_visited[word]
                if word not in visited:
                    # Save the level as the value of the dictionary, to save number of hops.
                    visited[word] = level + 1
                    queue.append((word, level + 1))
        return None

    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """

        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        # Since all words are of same length.
        self.length = len(beginWord)

        for word in wordList:
            for i in range(self.length):
                # Key is the generic word
                # Value is a list of words which have the same intermediate generic word.
                self.all_combo_dict[word[:i] + "*" + word[i + 1:]].append(word)

        # Queues for birdirectional BFS
        queue_begin = [(beginWord, 1)]  # BFS starting from beginWord
        queue_end = [(endWord, 1)]  # BFS starting from endWord

        # Visited to make sure we don't repeat processing same word
        visited_begin = {beginWord: 1}
        visited_end = {endWord: 1}
        ans = None

        # We do a birdirectional search starting one pointer from begin
        # word and one pointer from end word. Hopping one by one.
        while queue_begin and queue_end:

            # One hop from begin word
            ans = self.visitWordNode(queue_begin, visited_begin, visited_end)
            if ans:
                return ans
            # One hop from end word
            ans = self.visitWordNode(queue_end, visited_end, visited_begin)
            if ans:
                return ans

        return 0