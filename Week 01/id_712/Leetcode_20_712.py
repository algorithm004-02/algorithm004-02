class solution:
    def is_valid(self,s):
        stack=[]
        match={"(":")","[":"]","{":"}"}
        for c in s:
            #若在里面则压入栈
            if c in match:
                stack.append(c)
            #若找到对应的则取出
            else:
                if not stack or match[stack.pop()]!=c:
                    return False
        return not stack

if __name__=="__main__":
    s1=solution()
    print(s1.is_valid("([)]"))
