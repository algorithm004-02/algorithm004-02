# 第一遍 ，用了deque ，不断的 popleft() ，以为 这个性能比列表好；

#看了官方的题解，应该移动下标，，顿时，感觉自己很蠢。

#第三遍，看了官方题解后。这里有个问题？？？

#马上找到 python idle 测试了，

'''
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
2.240844687
>>>
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
2.317422119
>>>

# while i< len(g) and j<len(s) 用时，在下面，明显变长了。
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
3.233211371
>>>
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
3.2318194929999997

'''


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        g.sort()
        s.sort()
        res=0
        i,j =0,0

        qqq=len(g)
        ttt=len(s)
        while i<qqq and j<ttt :
       # while i< len(g) and j<len(s) :  #这里，每次执行while ，都会再执行一遍len 函数调用么？ 用时较多

            if s[j] >= g[i]:
                i+=1
                j+=1
                res+=1
            else:

                j+=1
        return res


'''
#first time

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        
        import collections
    
        qq=collections.deque(sorted(g))
    
        tt=collections.deque(sorted(s))
    
        res=0
    
        while qq and tt :
            
            ttt=tt[0]
            qqq=qq[0]
        
            if ttt >=qqq:
                qq.popleft()
                tt.popleft()
                res+=1
            else:
                if len(tt)==0 :break
                tt.popleft()
        return res

#second time

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        qq=sorted(g)
        tt=sorted(s)
        res=0
        qindex,tindex =0,0
        
        
        
        while qindex<len(qq) and tindex<len(tt) :

            if tt[tindex] >=qq[qindex]:
                qindex+=1
                tindex+=1
                res+=1
            else:
                
                tindex+=1
        return res

'''
