# https://leetcode.com/problems/plus-one/
# 66. Plus One

# Approach 1:
class Solution:
  def plusOne(self, digits: List[int]) -> List[int]:
    return [int(i) for i in str(int(''.join(str(j) for j in digits)) + 1)]

# Approach 2:
class Solution:
  def plusOne(self, digits: List[int]) -> List[int]:
    for i in range(len(digits) - 1, -1, -1):
      if digits[i] < 9: digits[i] += 1
        return digits
      digits[i] = 0
    return [1] + digits