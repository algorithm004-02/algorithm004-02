"""
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        """
        自己重写了一遍括号生成问题的剪枝算法
        实现的时候未能一气呵成，思路上还是边写边定义递归的参数
        下一次实现之前对自己的要求是先思考清楚所需要的参数，再实现
        """
        # Prepare Result
        result = []
        # General Result
        self.generate_result("", 0, 0, n, result)
        return result
    
    # General Result function
    def generate_result(self, current_val, right, left, n, result):
        # Terminator
        if right == n and left == n:
            result.append(current_val)
            return
        
        # Generate Left
        if left <= n and left >= right:
            self.generate_result(current_val + '(', right, left + 1, n, result)
            
        # Generate right
        if right <= left:
            self.generate_result(current_val + ')', right + 1, left, n, result)
        
        