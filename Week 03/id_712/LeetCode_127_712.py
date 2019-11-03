from collections import defaultdict
class Solution():
    def ladderLength(self,bword,eword,wordlist):
        length=1
        visited=set()
        if eword not in wordlist:
            return 0
        graph=defaultdict(set)
        for word in wordlist:
            for i in range(len(word)):
                wildcard=word[:i]+"_"+word[i+1:]
                graph[wildcard].add