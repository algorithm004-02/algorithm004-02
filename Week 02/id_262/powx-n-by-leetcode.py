# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         if n < 0:
#             x = 1 / x
#             n = -n
#
#         return self.pwn(x, n)
#
#     def pwn(self, x, n):
#         if n == 0:
#             return 1.0
#         res = self.pwn(x, int(n / 2))
#
#         if n % 2 == 0:
#             return res * res
#         else:
#             return res * res * x


# class Solution:
#
#     def fibo(self, n):
#         while True:
#             if n == 1:
#                 return 1
#             if n == 2:
#                 return 2
#             m = self.fibo(n - 1)
#             m2 = self.fibo(n - 2)
#             res = m + m2
#             if res > 900:
#                 return n
#
#             return res
# from typing import List
#
#
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         res = [[]]
#
#         def loop(start, tmp):
#             for n in range(start, len(nums)):
#                 res.append(tmp + [nums[n]])
#                 loop(n + 1, tmp + [nums[n]])
#
#         loop(0, [])
#         return res
#
#
# s = Solution()
# print(s.subsets([1, 2, 3, 4]))
from typing import List


# class Solution:
#     def letterCombinations(self, digits: str) -> List[str]:
#         obj = {
#             "2": "abc",
#             "3": "def",
#             "4": "ghi",
#             "5": "jkl",
#             "6": "mno",
#             "7": "pqrs",
#             "8": "tuv",
#             "9": "wxzy",
#         }
#
#         def backtrack(combination, digit):
#             if len(digit) == 0:
#                 res.append(combination)
#                 return
#
#             for i in obj[digit[0]]:
#                 backtrack(combination + i, digit[1:])
#
#         res = []
#         backtrack("", digits)
#         return res
#
#
# s = Solution()
# print(s.letterCombinations("23"))


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        obj = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxzy",
        }
        if len(digits) < 1:
            return []

        def helper(comb, dig):
            if len(dig) == 0:
                result.append(comb)
                return
            for i in obj[dig[0]]:
                helper(comb + i, dig[1:])

        result = []
        helper("", digits)
        return result


res = Solution().letterCombinations("433")
print(res)
