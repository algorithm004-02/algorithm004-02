class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        
        def backtrace(S="", left=0, right=0):
            if len(S) == 2*n:
                result.append(S)
            if left < n:
                backtrace(S+"(", left+1, right)
            if right < left:
                backtrace(S+")", left, right+1)
        
        backtrace()
        
        return result
