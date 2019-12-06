'''
针对 917 题

如果一开始，考虑用栈，也是可以的,一共遍历两遍，
拿起字母压入栈，并把这个位置，改写为w,也可以不改写

不是字母的位置，不改变，

第二次遍历，如果某个位置为w ，就从栈中弹出一个字母，放进去。

这就是脑袋里，没有两边向中中间这个思维，导致的。

而后同时用栈和队列，来解决它

'''


class Solution:
	def reverseOnlyLetters(self, S: str) -> str:
		left, r, s = 0, len(S) - 1, list(S)

		while left < r:
			if not s[left].isalpha():
				left += 1
			elif not s[r].isalpha():
				r -= 1
			else:
				s[left], s[r] = s[r], s[left]
				left += 1
				r -= 1
		return "".join(s)


'''

国际
class Solution:
    def reverseOnlyLetters(self, S):
        S, i, j = list(S), 0, len(S) - 1
        while i < j:
            if not S[i].isalpha():
                i += 1
            elif not S[j].isalpha():
                j -= 1
            else:
                S[i], S[j] , i, j  = S[j], S[i],i + 1, j - 1
                #i, j = i + 1, j - 1
        return "".join(S)


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
'''
