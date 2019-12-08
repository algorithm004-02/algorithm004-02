class Solution:
    def generateParenthesis(self, n: int):
        res = []
        left = right = 0

        def _doit(left, right, s):
            # the last level
            # if left ==n and right ==n :
            if right == n:  # when right==n ,left ==n too ,check right is fine.
                res.append(s)
                return

            # doit
            s1 = s + "("
            s2 = s + ")"

            # drill down
            if left < n:  # 剪枝 ，把= 也去掉，当left==2，进入下层，left+1=3
                _doit(left + 1, right, s1)

            if right < left:  # 只有有左括号时，左括号多时，才加右括号
                _doit(left, right + 1, s2)

            # some this level work

        _doit(left, right, "")
        return res
