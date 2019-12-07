# 17. Letter Combinations of a Phone Number
# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution:
  def letterCombinations(self, digits: str) -> List[str]:
    if digits == None or len(digits) == 0: return []
    map = {"2": "abc", "3": "def", 
           "4": "ghi", "5": "jkl", "6": "mno", 
           "7": "pqrs", "8": "tuv", "9": "wxyz"}
    res = []
    self.backtrack("", digits, 0, res, map)
    return res

  def backtrack(self, str, digits, index, res, map):
    if len(digits) == index:
      res.append(str)
      return

    letters = map.get(digits[index])
    for char in letters:
      self.backtrack(str + char, digits, index + 1, res, map)