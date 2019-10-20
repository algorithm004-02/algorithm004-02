"""
1、变成一个数字加一，然后变为数组

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = 0
        for i in range(0 , len(digits)):
            n = ( 10 ** (len(digits)-1 - i) )* digits[i] + n
        n += 1
        newlist = []
        for k in range( len(str(n))-1 , -1 , -1): 
            newlist.append(n % (10 ** (k + 1) )//(10 ** k))
            
        return newlist
"""
#2、循环进位    
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range( len(digits) -1 , -1 , -1):
            digits[i] += 1
            digits[i] = digits[i] % 10
            if digits[i] % 10 != 0:
                return digits
        digits[0] = 1
        digits.append(0)
        print(digits)
        return digits