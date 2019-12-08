# https://leetcode.com/problems/string-to-integer-atoi/
# 8. String to Integer (atoi)
class Solution:
  def myAtoi(self, str: str) -> int:
    lst = list(str.strip())
    
    if not lst: return 0
    
    sign = -1 if lst[0] == "-" else 1
    
    if lst[0] in ["-", "+"]: del lst[0]
      
    res, i = 0, 0
    while i < len(lst) and lst[i].isdigit():
      res = res * 10 + ord(lst[i]) - ord("0")
      i += 1
    
    return max(-2**31, min(res * sign, 2**31 - 1))