# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/

# 递归
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        data = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
        }
        result = []
        self._fn(result, digits, 0, '', data)
        return result

    def _fn(self, result: List[str], digits: str, level: int, s: str, data: map):
        if len(digits) == level:
            result.append(s)
            return
        letters = data.get(digits[level])
        for i in letters:
            self._fn(result, digits, level + 1, s + i, data)
