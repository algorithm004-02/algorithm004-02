
#最长有效括号
# 暴力解决：每次取偶数个，时间复杂度：n^2

def isValidParentheses(s: str) -> bool:
    stack = []
    for i in range(len(s)):
        if s[i] == "(":
            stack.append("(")
        elif len(stack) > 0:
            stack.pop()
        else:
            return False
    return (len(stack) == 0)

def longestValidParentheses_recursion(s: str) -> int:
        if not s or len(s) <= 0:
            return 0
        res = 0
        
        for i in range(len(s)):
            for j in range(i+2,len(s)+1, 2):
                if (isValidParentheses(s[i:j])):
                    res = max(res, j-i)

        return res


#DP 解决
def longestValidParentheses_dp(s: str) -> int:
        n = len(s)
        if n <= 1: return 0
        dp = [0] * n
        res = 0
        for i in range(n):
            if i>0 and s[i] == ")":
                if  s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2
                elif s[i - 1] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
            res = max(res,dp[i])
        return res

print("recursion:"+str(longestValidParentheses_recursion("(())()")))
print("dp:"+str(longestValidParentheses_dp("(())()")))