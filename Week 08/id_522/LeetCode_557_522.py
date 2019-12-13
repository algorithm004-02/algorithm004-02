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
        
        
        
>>> from timeit import timeit
>>> setup = 's = "Let\'s take LeetCode contest"'
>>> statements = ("' '.join(s.split()[::-1])[::-1]",
	          "' '.join(x[::-1] for x in s.split())",
	          "' '.join([x[::-1] for x in s.split()])")
>>> for stmt in statements:
        print ' '.join('%.2f' % timeit(stmt, setup) for _ in range(5)), 'seconds for:', stmt

0.79 0.78 0.80 0.82 0.79 seconds for: ' '.join(s.split()[::-1])[::-1]
2.10 2.14 2.08 2.06 2.13 seconds for: ' '.join(x[::-1] for x in s.split())
1.27 1.26 1.28 1.28 1.26 seconds for: ' '.join([x[::-1] for x in s.split()])       
        
'''
