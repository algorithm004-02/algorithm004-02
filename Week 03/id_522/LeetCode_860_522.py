# 看了官方题解，服了，
# 不用字典，
# 不用处理bills 为空的情况，
# 不用处理20面额的

class Solution(object):  # aw
    def lemonadeChange(self, bills):
        five = ten = 0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if not five: return False
                five -= 1
                ten += 1
            else:
                if ten and five:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        return True


# 我自己写的，第一遍
'''
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:

        if not bills:return True
        
        if bills[0]>5 :return False
        
        ll=len(bills)
        dd={5:1,10:0,20:0}
        now=5
        
        for i in range(1,ll):
            
            if bills[i]==5: 
                dd[5]+=1
                
            elif bills[i]==10:
                if dd[5]>=1:
                    dd[5]-=1
                    dd[10]+=1
                else:return False
                
            else:
                
                #get one 20
                #pay back 15 
                if dd[10]>=1 and dd[5]>=1:
                    dd[20]+=1
                    dd[5]-=1
                    dd[10]-=1
                elif dd[10]==0 and dd[5]>=3:
                    dd[5]-=3
                    dd[20]+=1
                else:
                    return False
        return True
'''
