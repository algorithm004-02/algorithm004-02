# 127. Word Ladder
# https://leetcode.com/problems/word-ladder/
# approach 1: bfs
class Solution:
  def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
    if endWord not in wordList: return 0
    
    commDict = collections.defaultdict(list)
    wordLen = len(beginWord)
    
    for word in wordList:
      for i in range(wordLen):
        commDict[word[:i] + "*" + word[i+1:]].append(word)
    
    queue = collections.deque([(beginWord, 1)])
    visited = {beginWord}
    
    while queue:
      currWord, level = queue.popleft()
      for i in range(wordLen):
        commWord = currWord[:i] + "*" + currWord[i+1:]
        
        for word in commDict[commWord]:
          if word == endWord:
            return level + 1       
          
          if word not in visited:
              visited.add(word)
              queue.append((word, level + 1))   
              
        commDict[commWord] = []
        
    return 0

# approach 2: optimize
class Solution:
  def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
    if endWord not in wordList: return 0
    
    level = 2
    wordSet = set(wordList)
    wordLen = len(beginWord)
    forward, backward = {beginWord}, {endWord}
    
    while forward and backward:
      if len(forward) > len(backward):
        forward, backward = backward, forward
        
      wordSet -= forward
      nextForward = set()
      
      for word in forward:
        for i in range(wordLen):
          h, t = word[:i], word[i+1:]
          for c in string.ascii_lowercase:
            comb = h + c + t
            if comb in wordSet:
              if comb in backward:
                return level
            
              nextForward.add(comb)
            
      forward = nextForward
      level += 1
      
    return 0