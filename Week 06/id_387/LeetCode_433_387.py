# https://leetcode.com/problems/minimum-genetic-mutation/
# 433. Minimum Genetic Mutation
# approach 1: bfs
# approach 2: bidirectional bfs
class Solution:
  def minMutation(self, start: str, end: str, bank: List[str]) -> int:
    if end not in bank: return -1
    forward, backward = {start}, {end}
    level = 0
    
    while forward and backward:
      nextForward = set()
      for word in forward:
        for i in range(len(word)):
          for ch in {"A", "C", "G", "T"}:
            newWord = word[:i] + ch + word[i+1:]
            if newWord in backward:
              return level + 1
            if newWord in bank:
              nextForward.add(newWord)
              bank.remove(newWord)
      
      forward = nextForward
      level += 1
      
      if len(forward) > len(backward):
        forward, backward = backward, forward
      
    return -1