# NOTE

  本周先看视频，动态规划的状态定义，需要费脑子。不是那么容易想到。
  
  这周，感觉收获的，还是老师说的，针对一段代码，要找到哪里可以优化，这个很重要。
  
  思维的方向，或者说数据的操作方向，很重要。。
  
  下面是917 题
  
  '''
针对 917 题

如果一开始，考虑用栈，也是可以的,一共遍历两遍，
拿起字母压入栈，并把这个位置，改写为w,也可以不改写

不是字母的位置，不改变，

第二次遍历，如果某个位置为w ，就从栈中弹出一个字母，放进去。

这就是脑袋里，没有两边向中中间这个思维，导致的。

而后同时用栈和队列，来解决它

```
#两个指针，从两边向中间
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        left,r,s=0,len(S)-1,list(S)

        while left<r:
            if not s[left].isalpha(): left+=1
            elif not s[r].isalpha(): r-=1
            else:
                s[left],s[r]=s[r],s[left]
                left+=1
                r-=1
        return "".join(s)

#遍历两遍
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        s=list(S)
        stack=[]
        for i in s:
            if i.isalpha(): stack.append(i)

        for i in range(len(s)):
            if s[i].isalpha():     #use isalpha() two times 
                s[i]=stack.pop()
        return "".join(s)

#同时用到栈和队列
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        s=list(S)
        stack=[]
        import collections
        q=collections.deque()
        for i,v in enumerate(s):
            if v.isalpha():
                stack.append(v)
                q.append(i)

        while q:
            s[q.popleft()]=stack.pop()
        return "".join(s)
```
有些题目，也能感觉到思维的方向的重要作用。这道题体现的就不错。


再有，对于python 学习者，要使用这个语言的特异功能。 在557题目上 
``` 
class Solution: 
    def reverseWords(self, s: str) -> str: 
        dao=s[::-1]
        kk=dao.split() 
        return " ".join(kk[::-1])


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s[::-1].split()[::-1])   #一行搞定
        
        
        
        
        
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
 ```
 
 
 本周体会到了，思维的方向，在438 题中也感受到了
 
 通过上面三道题，我们可以总结出滑动窗口算法的抽象思想： 
 ```
 int left = 0, right= 0;

while (right < s.size()) {
    window.add(s[right]);
    right++;
    
    while (valid) {
        window.remove(s[left]);
        left++;
    }
}

作者：labuladong
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
```

这个左右指针，来解决滑动窗口问题，思想很重要。

本周有些精力不足，写石墨文档一个 https://shimo.im/docs/VRqwcg6dQPyTjpPh

