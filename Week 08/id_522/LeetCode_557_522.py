class Solution:
    def reverseWords(self, s: str) -> str:
        dao=s[::-1]
        kk=dao.split()
        return " ".join(kk[::-1])

'''
class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s[::-1].split()[::-1])
        
        
        
        
        
class Solution:
    def reverseWords(self, s: str) -> str:
        
        #use stack
        tt=""
        stack=[]
        for i in s:
            if i != " " :
                stack.append(i)
                continue
            
            while stack:
                tt+=stack.pop()
            tt+=" "
        while stack:
            tt+=stack.pop()
        return tt        
        
        
        
        
        
'''
