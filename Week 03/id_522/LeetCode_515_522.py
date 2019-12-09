# use dfs
class Solution:
    def largestValues(self, root):
        if not root: return []
        res = {}

        def help(node, depth):
            # the end
            if not node: return

            # this level
            if depth not in res:
                res[depth] = node.val
            else:
                res[depth] = max(node.val, res[depth])

            # drill down
            help(node.left, depth + 1)
            help(node.right, depth + 1)

        help(root, 1)
        return [res[i] for i in res]

# use bfs
'''
class Solution:
    def largestValues(self, root):
        if not root: return []

        quque = [root]
        res = []
        while quque:
            level = -float('Inf')
            ll = len(quque)

            for i in range(ll):
                node = quque.pop(0)
                if node.val > level: level = node.val

                if node.left: quque.append(node.left)
                if node.right: quque.append(node.right)
            res.append(level)
        return res
'''
