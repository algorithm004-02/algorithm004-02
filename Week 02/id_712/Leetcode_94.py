class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        stack=[root]
        result=[]
        while stack:
            node=stack.pop()
            result.append(node.val)
            for child in node.children:
                stack.append(child)
        return result[::-1]