# 860. Lemonade Change
# https://leetcode.com/problems/lemonade-change/
# approach 1: greedy
# time complexity: O(n), space complexity: O(1)
class Solution:
  def lemonadeChange(self, bills: List[int]) -> bool:
    five = ten = 0
    if not bills[0] == 5: return False
    for bill in bills:
      if bill == 5: 
        five += 1
      elif bill == 10:
        if not five: return False
        five -= 1
        ten += 1
      else:
        if ten and five: 
          five -= 1
          ten -= 1
        elif five >= 3:
          five -= 3
        else: 
          return False
    return True