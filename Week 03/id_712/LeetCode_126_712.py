import collections
import string
class Solution(object):
    def findLadders(self,beginWord,endWord,wordList):
        dic=set(wordList)
        dic.add(endWord)
        level={beginWord}
        parents=collections.defaultdict(set)
        while level and endWord not in parents:
            next_level=collections.defaultdict(set)
            for node in level:
                for char in string.ascii_lowercase:
                    for i in range(len(beginWord)):
                        n=node[:i]+char+node[i+1:]
                        if n in dic and n not in parents:
                            next_level[n].add(node)
            level=next_level
            parents.update(next_level)
        res=[[endWord]]
        while res and res[0][0]!=beginWord:
            res=[[p]+r for r in res for p in parents[r[0]]]
        return res
