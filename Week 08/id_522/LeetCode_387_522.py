class Solution:
    def firstUniqChar(self, s: str) -> int:
        dd,a=collections.Counter(s),0
        for i in s:
            if dd[i]==1:return a
            else:a+=1
        return -1


'''   
class Solution:
    def firstUniqChar(self, s: str) -> int:
        letters='abcdefghijklmnopqrstuvwxyz'
        index=[s.index(x) for x in letters if s.count(x)==1]
        return min(index) if len(index)>0 else -1 
'''
