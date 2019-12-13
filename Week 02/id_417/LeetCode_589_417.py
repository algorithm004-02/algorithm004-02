class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        if root is None:
            return result
        
        result.append(root.val)
        for c in root.children:
            result.extend(self.preorder(c))
        
        return result
