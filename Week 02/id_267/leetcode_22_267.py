# 22. 括号生成
# 合法的条件：
# 1. left随时加，只要不超标
# 2. right left个数>right个数

class Solution:

    result = [] 
    
    def generateParenthesis(self, n: int):
        global result
        self.generate(0, 0, n, "")
        return result

    def generate(self, left: int, right: int, n: int, s: str):
        # recursion terminator 递归终结条件
        if (left == n and right == n) :

            result.append(s)
            return

        # process logic in current level 处理当前逻辑

        # drill down 下探到下一层
        if left < n:
            self.generate(left + 1, right, n, s+"(")

        if left > right:
            self.generate(left, right +1,n , s+")")

        # reverse the current level status if needed 清理当前层


#######################测试用例#######################
n = 3
obj = Solution()
print(obj.generateParenthesis(n))
