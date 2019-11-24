# 随着做题遍数的增加，对优化代码，有了理解。

#7th   56ms  ,99.73%
class Solution:
    def thirdMax(self, n):
        s=len(n)
        if s==1:return n[0]
        if s==2:return n[0] if n[0]>n[1] else n[1]
        m1=m2=m3=float("-inf")
        ss=set()
        for i in n:
            if i not in ss:
                ss.add(i)
                if i >m1:
                    m3=m2
                    m2=m1
                    m1=i
                elif i>m2:
                    m3,m2=m2,i
                elif i>m3:
                    m3=i
        return m3 if m3>float("-inf") else m1

#8th

'''
class Solution:
    def thirdMax(self, n):
        s=len(n)
        if s==1:return n[0]
        if s==2:return n[0] if n[0]>n[1] else n[1]
        m1=m2=m3=float("-inf")
        ss=set()
        for i in n:
            if i not in ss:
                ss.add(i)
                if i>m1:
                    m3,m2,m1=m2,m1,i
                elif i>m2:
                    m3,m2=m2,i
                elif i>m3:
                    m3=i
        return m3 if m3>float("-inf") else m1
'''



#1th

'''
class Solution:
    def thirdMax(self, nums: List[int]) -> int:


        size=len(nums)

        if size==1:return nums[0]
        if size ==2:return max(nums)

        big=float("-inf")
        bi=float("-inf")
        b=float("-inf")
        end=float("-inf")
        ss=set()

        for i in nums:
            if i in ss:continue

            else:
                ss.add(i)
                if i >big:
                    b=max(b,bi)
                    bi=max(bi,big)
                    big=i
                elif i>bi:
                    b=max(b,bi)
                    bi=i
                elif i>b:
                    b=i

        if b==end:return big
        else:
            return b


'''

#2th
'''
class Solution:
    def thirdMax(self, n):
        s=len(n)
        if s==1:return n[0]
        if s==2:return n[0] if n[0]>n[1] else n[1]

        big=float("-inf")
        bi=float("-inf")
        b=float("-inf")
        end=float("-inf")
        ss=set()
        for i in n:
            if i in ss:continue
            else:
                ss.add(i)
                if i >big:
                    if bi>b:b=bi
                    if big>bi:bi=big
                    big=i
                elif i>bi:
                    if bi>b:b=bi
                    bi=i
                elif i>b:b=i
        return big if b==end else b

'''

#3th
'''
class Solution:
    def thirdMax(self, n):
        s=len(n)
        if s==1:return n[0]
        if s==2:return n[0] if n[0]>n[1] else n[1]

        big=bi=b=float("-inf")
        ss=set()
        for i in n:
            if i in ss:continue
            else:
                ss.add(i)
                if i >big:
                    b=bi
                    bi=big
                    big=i
                elif i>bi:
                    b=bi
                    bi=i
                elif i>b:b=i
        return big if b==float("-inf") else b

'''


#4th  这样写，就不需要，前面的判断了，而且，思路很清晰，很python

'''
class Solution(object):
    def thirdMax(self, nums):
        v = [float('-inf'), float('-inf'), float('-inf')]
        for num in nums:
            if num not in v:
                if num > v[0]:   v = [num, v[0], v[1]]
                elif num > v[1]: v = [v[0], num, v[1]]
                elif num > v[2]: v = [v[0], v[1], num]
        return max(nums) if float('-inf') in v else v[2]


'''

#5th
'''
class Solution(object):
    def thirdMax(self, nums):
        v = [float('-inf'), float('-inf'), float('-inf')]
        for num in nums:
            if num not in v:
                if num > v[0]:   v = [num, v[0], v[1]]
                elif num > v[1]: v = [v[0], num, v[1]]
                elif num > v[2]: v = [v[0], v[1], num]
        return v[0] if float('-inf') in v else v[2]   #优化
'''
#6th
'''
class Solution(object):
    def thirdMax(self, nums):

        one = two = three = -float("inf")
        for i in nums:
            if i > one:
                one, two, three = i, one, two
            elif i > two and i < one:     # 没有= ，把重复的删除掉
                two, three = i, two
            elif i > three and i < two:   # 没有= ，把重复的删除掉
                three = i
        return three if three != -float("inf") else one
'''

