class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five,ten= 0,0
        for bill in bills:
            if bill == 5: five += 1
            elif bill == 10: five, ten = five - 1, ten + 1
            elif ten > 0: five, ten = five - 1, ten - 1
            else: five -= 3
            if five < 0: return False
        return True
