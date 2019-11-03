class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # 这道题的解法是看了官方解答的思路后自己重新写的
        # 关于回溯感觉掌握得不太好
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
