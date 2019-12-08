class Solution:
    def longestValidParentheses(self, s: str) -> int:

        stack = [-1]
        count = 0
        for item in range(len(s)):
            if s[item] == "(":
                stack.append(item)
            else:
                stack.pop()
                if not stack:
                    stack.append(item)
                else:
                    count = max(count, item - stack[-1])
        return count
