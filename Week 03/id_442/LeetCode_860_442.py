# https://leetcode-cn.com/problems/lemonade-change/submissions/

class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five, ten = 0, 0
        for bill in bills:
            if bill == 5:   # 收到5美元
                five += 1
            elif bill == 10:    # 收到10美元 手里有5美元才能找零
                if not five:
                    return False
                five -= 1
                ten += 1
            else:               # 收到20美元 手里有 10美元+5美元 或 3张5美元 才可以找零
                if five and ten:
                    five -= 1
                    ten -= 1
                elif five == 3:
                    five -= 3
                else:
                    return False
        return True
