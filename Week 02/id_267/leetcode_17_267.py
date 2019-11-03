# Python优雅的递推式构造列表（List comprehension）
class Solution:
    def letterCombinations(self, digits: str):
        mapping = {
            '1': list(''),
            '2': list('abc'),
            '3': list('def'),
            '4': list('ghi'),
            '5': list('jkl'),
            '6': list('mno'),
            '7': list('pqrs'),
            '8': list('tuv'),
            '9': list('wxyz'),
            }
        if not digits: return []
        ls1 = ['']
        for i in digits:
            ls1 = [x + y for x in ls1 for y in mapping[i]]
        return ls1



################test cases##############
nums = "67"
obj = Solution()
print(obj.letterCombinations(nums))