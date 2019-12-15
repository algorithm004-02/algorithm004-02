class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        if root is None:
            return result
        
        for c in root.children:
            result.extend(self.postorder(c))
            
        result.append(root.val)
        
        return result
